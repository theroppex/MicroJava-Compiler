package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.ArrayElementDesignatorList;
import rs.ac.bg.etf.pp1.ast.ArrayVar;
import rs.ac.bg.etf.pp1.ast.AsignDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.BoolConstFactor;
import rs.ac.bg.etf.pp1.ast.BooleanConst;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.CharConstFactor;
import rs.ac.bg.etf.pp1.ast.ClassFieldDesignatorList;
import rs.ac.bg.etf.pp1.ast.ComplexFactor;
import rs.ac.bg.etf.pp1.ast.ComplexFactorList;
import rs.ac.bg.etf.pp1.ast.ComplexTermList;
import rs.ac.bg.etf.pp1.ast.ConstDeclartion;
import rs.ac.bg.etf.pp1.ast.DecDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.EmptyDesignatorList;
import rs.ac.bg.etf.pp1.ast.Expresion;
import rs.ac.bg.etf.pp1.ast.FunctionCallStatement;
import rs.ac.bg.etf.pp1.ast.FunctionResultNoParamFactor;
import rs.ac.bg.etf.pp1.ast.FunctionResultWParamFactor;
import rs.ac.bg.etf.pp1.ast.IncDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.MethodDeclaration;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.NegativeFactor;
import rs.ac.bg.etf.pp1.ast.NewArrayFactor;
import rs.ac.bg.etf.pp1.ast.NewClassFactor;
import rs.ac.bg.etf.pp1.ast.NonArrayVar;
import rs.ac.bg.etf.pp1.ast.NumericConst;
import rs.ac.bg.etf.pp1.ast.NumericConstFactor;
import rs.ac.bg.etf.pp1.ast.PrintStatement;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ProgramName;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.ReturnExpresion;
import rs.ac.bg.etf.pp1.ast.ReturnStatement;
import rs.ac.bg.etf.pp1.ast.SingleElementFactorList;
import rs.ac.bg.etf.pp1.ast.SingleTermList;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.VarDeclaration;
import rs.ac.bg.etf.pp1.ast.VariableFactor;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor{
	
	private List<Struct> builtInTypes = new ArrayList<Struct>(Arrays.asList(
			Tab.intType,
			Tab.charType,
			Tab.find("bool").getType()
			));
	
	private boolean errorDetected = false;
	
	private boolean needsReturnStmt = false;
	private boolean hasReturnStmt = false;
	private boolean hasMain = false;
	
	private Obj currentType = null;
	private Obj currentRetType = null;

	Logger log = Logger.getLogger(getClass());
	
	public boolean isErrorDetected() {
		return errorDetected;
	}
	
	private String printVar(Obj objToVisit) {
		StringBuilder output = new StringBuilder();
				
		switch (objToVisit.getKind()) {
			case Obj.Con:  output.append("Con "); break;
			case Obj.Var:  output.append("Var "); break;
			case Obj.Type: output.append("Type "); break;
			case Obj.Meth: output.append("Meth "); break;
			case Obj.Fld:  output.append("Fld "); break;
			case Obj.Prog: output.append("Prog "); break;
		}
		
		output.append(objToVisit.getName());
		output.append(": ");
		output.append(objToVisit.getAdr());
		output.append(", ");
		output.append(objToVisit.getLevel());
				
		return output.toString();
	}
	
	private void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" - na liniji ").append(line);
		log.error(msg.toString());
	}

	private void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" - na liniji ").append(line);
		log.info(msg.toString());
	}
	
	private void report_debug(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.debug(msg.toString());
	}
	
	private Struct getDesignatorType(Designator designator) {
		Obj variable = Tab.find(designator.getDesignator_name().getName());
		if(designator.getDesignator_list() instanceof EmptyDesignatorList) {
			switch (variable.getKind()) {
			case Obj.Con:
				return variable.getType();
			case Obj.Var:
				return variable.getType();
			default:
				return Tab.noType;
			}
		}
		else {
			if(designator.getDesignator_list() instanceof ClassFieldDesignatorList) {
				report_error("Semanticka greska: Klasna polja nisu podrzana", designator);
			}
			else {
				if(Struct.Array != variable.getType().getKind()) {
					report_error("Semanticka greska: Ocekivana referenca na Array", designator);
				}
				else {
					return variable.getType().getElemType();
				}
			}
		}
		return null;
	}

	
	@Override
	public void visit(Program program) { 
		report_debug("Posecen Program", program);
		if(!hasMain) {
			report_error("Semanticka greska: Nije definisana main metoda", program);
		}
		program.obj = program.getProg_id().obj;
		Tab.chainLocalSymbols(program.getProg_id().obj);
		Tab.closeScope();
	}
	
	@Override
    public void visit(ProgramName programName) {
		report_debug("Posecen ProgramName", programName);
		programName.obj = Tab.insert(Obj.Prog, programName.getId(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(ConstDeclartion constDeclartion) {
		report_debug("Posecen ConstDeclaration", constDeclartion);
		currentType = null;
	}

	@Override
	public void visit(Type type) { 
		report_debug("Posecen Type", type);
		
		Obj typeNode = Tab.find(type.getId());
		
		if(Tab.noObj.equals(typeNode)) {
			report_error("Semanticka greska: Tip " + type.getId() + " nije validan", type);
			errorDetected = true;
			type.struct = Tab.noType;
			currentType = null;
		}
		else {
			if(typeNode.getKind() == Obj.Type) {
				type.struct = typeNode.getType();
				currentType = typeNode;
			}
			else {
				report_error("Semanticka greska: Tip " + type.getId() + " nije validan", type);
				type.struct = Tab.noType;
				currentType = null;
				errorDetected = true;
			}
		}
	}
	
	@Override
	public void visit(BooleanConst booleanConst) { 
		report_debug("Posecen BooleanConst", booleanConst);
		
		Obj boolType = Tab.find("bool");
		if(!boolType.equals(currentType)) {
			report_error("Semanticka greska: Tip nije kompatibilan ocekivan bool",
					booleanConst);
		}
		else {
			Obj f = Tab.find(booleanConst.getId());
			if(!Tab.noObj.equals(f)) {
				report_error("Semanticka greska: Konstanta " + booleanConst.getId() + " je vec definisana", booleanConst);
			}
			else {
				Obj constant = Tab.insert(Obj.Con, booleanConst.getId(), currentType.getType());
				int val = "true".equals(booleanConst.getC()) ? 1 : 0;
				constant.setAdr(val);
			}
		}
	}
	
	@Override
    public void visit(CharConst charConst) { 
		report_debug("Posecen CharConst", charConst);
		
		Obj charType = Tab.find("char");
		if(!charType.equals(currentType)) {
			report_error("Semanticka greska: Tip nije kompatibilan ocekivan char",
					charConst);
		}
		else {
			Obj f = Tab.find(charConst.getId());
			if(!Tab.noObj.equals(f)) {
				report_error("Semanticka greska: Konstanta " + charConst.getId() + " je vec definisana", charConst);
			}
			else {
				Obj constant = Tab.insert(Obj.Con, charConst.getId(), Tab.charType);
				constant.setAdr((int)charConst.getC());
			}
		}
	}
	
	@Override
    public void visit(NumericConst numericConst) { 
		report_debug("Posecen NumericConst", numericConst);
		
		Obj intType = Tab.find("int");
		if(!intType.equals(currentType)) {
			report_error("Semanticka greska: Tip nije kompatibilan ocekivan int",
					numericConst);
		}
		else {
			Obj f = Tab.find(numericConst.getId());
			if(!Tab.noObj.equals(f)) {
				report_error("Semanticka greska: Konstanta " + numericConst.getId() + " je vec definisana", numericConst);
			}
			else {
				Obj constant = Tab.insert(Obj.Con, numericConst.getId(), Tab.intType);
				constant.setAdr(numericConst.getC());
			}
		}
	}
	
	@Override
	public void visit(VarDeclaration varDeclaration) { 
		report_debug("Posecen VarDeclaration", varDeclaration);
		currentType = null;
	}
	
	@Override
	public void visit(NonArrayVar nonArrayVar) { 
		report_debug("Posecen NonArrayVar", nonArrayVar);
		
		//Obj sRes = Tab.find(nonArrayVar.getName());
		Obj sRes = Tab.currentScope().findSymbol(nonArrayVar.getName());
		if(currentType == null) {
			report_error("Semanticka greska: Tip nije validan", nonArrayVar);
		}
		else {
			if(sRes != null) {
				report_error("Semanticka greska: Varijabla " + nonArrayVar.getName() + " je vec deklarisana", nonArrayVar);
			}
			else {
				Tab.insert(Obj.Var, nonArrayVar.getName(), currentType.getType());
			}
		}
	}
	
	@Override
	public void visit(ArrayVar arrayVar) {
		report_debug("Posecen ArrayVar", arrayVar);
		//Obj sRes = Tab.find(arrayVar.getName());
		Obj sRes = Tab.currentScope().findSymbol(arrayVar.getName());
		if(currentType == null) {
			report_error("Semanticka greska: Tip nije validan", arrayVar);
		}
		else {
			if(sRes != null) {
				report_error("Semanticka greska: Varijabla " + arrayVar.getName() + " je vec deklarisana", arrayVar);
			}
			else {
				Tab.insert(Obj.Var, arrayVar.getName(), new Struct(Struct.Array, currentType.getType()));
			}
		}
	}
	
	@Override
	public void visit(MethodDeclaration methodDeclaration) { 
		report_debug("Posecen MethodDeclaration", methodDeclaration);
		
		if(methodDeclaration.getMethod_name().obj != null) {
			Tab.chainLocalSymbols(methodDeclaration.getMethod_name().obj);
		}
		Tab.closeScope();
		if(needsReturnStmt && (!hasReturnStmt)) {
			report_error("Semanticka greska: Nije definisan return statement", methodDeclaration);
		}
		
		needsReturnStmt = false;
		hasReturnStmt = false;
		currentRetType = null;
	}
	
	public void visit(MethodName methodName) { 
		report_debug("Posecen MethodName", methodName);
		
		Obj sRes = Tab.find(methodName.getName());
		if(!Tab.noObj.equals(sRes)) {
			report_error("Semanticka greska: Metoda vec definisana " + methodName.getName(), methodName);
		}
		else {
			if("main".equals(methodName.getName())) {
				hasMain = true;
			}
			if(currentType == null) {
				//TODO Obrati paznju na tip metode u zavisnosti od ret
				methodName.obj = Tab.insert(Obj.Meth, methodName.getName(), Tab.noType);
			}
			else {
				methodName.obj = Tab.insert(Obj.Meth, methodName.getName(), currentType.getType());
				needsReturnStmt = true;
				currentRetType = currentType;
				currentType = null;
			}
		}
		Tab.openScope();
	}
	
	@Override
	public void visit(ArrayElementDesignatorList arrayElementDesignatorList) {
		arrayElementDesignatorList.struct = new Struct(Struct.Array);
		if(!(arrayElementDesignatorList.getDesignator_list() instanceof EmptyDesignatorList)) {
			report_error("Semanticka greska: Nisu podrzani visedimenzioni nizovi", arrayElementDesignatorList);
		}
		if(arrayElementDesignatorList.getExpr().struct != Tab.intType) {
			report_error("Semanticka greska: Broj elemenata niza mora biti tipa int", arrayElementDesignatorList);
		}
	}
	
	@Override
	public void visit(Designator designator) {
		Obj variable = Tab.find(designator.getDesignator_name().getName());
		designator.obj = Tab.noObj;
		if(Tab.noObj.equals(variable)) {
			report_error("Semanticka greska: Varijabla " + designator.getDesignator_name().getName()
			+ " nije deklarisana", designator);
		}
		else {
			report_info("Detektovan simbol " + printVar(variable), designator);
			if(designator.getDesignator_list() instanceof ArrayElementDesignatorList) {
				designator.obj = new Obj(Obj.Elem, variable.getName(), variable.getType().getElemType(), variable.getAdr(), variable.getLevel());
			}
			else {
				designator.obj = variable;
			}
		}
	}
	
	@Override
	public void visit(VariableFactor variableFactor) {
		variableFactor.struct = getDesignatorType(variableFactor.getDesignator());
	}
	
	@Override
	public void visit(FunctionResultWParamFactor functionResultWParamFactor) {
		String name = functionResultWParamFactor.getDesignator().getDesignator_name().getName();
		functionResultWParamFactor.struct = Tab.noType;
		Obj var = Tab.find(name);
		if(var.getKind() == Obj.Meth) {
			functionResultWParamFactor.struct = var.getType();
		}
		else {
			report_error("Semanticka greska: Ocekivana metoda", functionResultWParamFactor);
		}
	}
	
	@Override
	public void visit(FunctionResultNoParamFactor functionResultNoParamFactor) {
		String name = functionResultNoParamFactor.getDesignator().getDesignator_name().getName();
		functionResultNoParamFactor.struct = Tab.noType;
		Obj var = Tab.find(name);
		if(var.getKind() == Obj.Meth) {
			functionResultNoParamFactor.struct = var.getType();
		}
		else {
			report_error("Semanticka greska: Ocekivana metoda", functionResultNoParamFactor);
		}
	}
	
	@Override
	public void visit(CharConstFactor charConstFactor) {
		charConstFactor.struct = Tab.charType;
	}
	
	@Override
    public void visit(BoolConstFactor boolConstFactor) {
    	boolConstFactor.struct = Tab.find("bool").getType();
    }
	
	@Override
    public void visit(NumericConstFactor numericConstFactor) {
    	numericConstFactor.struct = Tab.intType;
    }
	
	@Override
    public void visit(NewClassFactor newClassFactor) {
		report_error("Semanticka greska: Nisu podrzani klasni tipovi", newClassFactor);
		currentType = null;
	}
	
    public void visit(NewArrayFactor newArrayFactor) {
    	newArrayFactor.struct = Tab.noType;
    	if(newArrayFactor.getExpr().struct != Tab.intType) {
    		report_error("Semanticka greska: Broj elemenata niza mora biti tipa int", newArrayFactor);
    	}
    	else {
    		if(currentType != null) {
        		newArrayFactor.struct = new Struct(Struct.Array, currentType.getType());
        	}
    	}
    	currentType = null;
    }
    
    @Override
    public void visit(ComplexFactor complexFactor) {
    	complexFactor.struct = complexFactor.getExpr().struct;
    }
    
    @Override
    public void visit(SingleElementFactorList singleElementFactorList) {
    	singleElementFactorList.struct = singleElementFactorList.getFactor().struct;
    }
    
    @Override
    public void visit(ComplexFactorList complexFactorList) {
    	complexFactorList.struct = Tab.noType;
    	
    	if(complexFactorList.getFactor().struct != Tab.intType || complexFactorList.getFactor_list().struct != Tab.intType) {
    		report_error("Semanticka greska: Ocekivani operandi tipa int", complexFactorList);
    	}
    	else {
    		complexFactorList.struct = Tab.intType;
    	}
    }
    
    @Override
    public void visit(Term term) {
    	term.struct = term.getFactor_list().struct;
    }
    
    @Override
    public void visit(SingleTermList singleTermList) {
    	singleTermList.struct = singleTermList.getTerm().struct;
    }
    
    @Override
    public void visit(ComplexTermList complexTermList) {
    	complexTermList.struct = Tab.noType;
    	
    	if(complexTermList.getTerm().struct != Tab.intType || complexTermList.getTerm_list().struct != Tab.intType) {
    		report_error("Semanticka greska: Ocekivani operandi tipa int", complexTermList);
    	}
    	else {
    		complexTermList.struct = Tab.intType;
    	}
    }
    
    @Override
    public void visit(Expresion expresion) {
    	expresion.struct = expresion.getTerm_list().struct;
    }
    
    /*
    @Override
    public void visit(NegativeExpresion negativeExpresion) {
    	negativeExpresion.struct = Tab.noType;
    	
    	if(negativeExpresion.getTerm_list().struct != Tab.intType) {
    		report_error("Semanticka greska: ocekivan izraz tipa int", negativeExpresion);
    	}
    	else {
    		negativeExpresion.struct = Tab.intType;
    	}
    }
    */
    
    @Override
    public void visit(AsignDesignatorStatement asignDesignatorStatement) {
    	if(Tab.find(asignDesignatorStatement.getDesignator().getDesignator_name().getName()).getKind() == Obj.Con
    		|| Tab.find(asignDesignatorStatement.getDesignator().getDesignator_name().getName()).getKind() == Obj.Meth) {
    		report_error("Semanticka greska: Nije dozvoljena dodela vrednosti", asignDesignatorStatement);
    	}
    	else {
    		Struct type = getDesignatorType(asignDesignatorStatement.getDesignator());
        	if(!asignDesignatorStatement.getExpr().struct.assignableTo(type)) {
        		report_error("Semanticka greska: Tipovi prilikom dodele nisu kompatibilni", asignDesignatorStatement);
        	}
    	}
    }
    
    @Override
    public void visit(DecDesignatorStatement decDesignatorStatement) {
    	if(Tab.find(decDesignatorStatement.getDesignator().getDesignator_name().getName()).getKind() == Obj.Con) {
    		report_error("Semanticka greska: Nije dozvoljena dekrementacija konstanti", decDesignatorStatement);
    	}
    	else {
    		Struct type = getDesignatorType(decDesignatorStatement.getDesignator());
        	if(type != Tab.intType) {
        		report_error("Semanticka greska: Tip prilikom dekrementacije mora biti int", decDesignatorStatement);
        	}
    	}
    }
    
    @Override
    public void visit(IncDesignatorStatement incDesignatorStatement) {
    	if(Tab.find(incDesignatorStatement.getDesignator().getDesignator_name().getName()).getKind() == Obj.Con) {
    		report_error("Semanticka greska: Nije dozvoljena inkrementacija konstanti", incDesignatorStatement);
    	}
    	else {
    		Struct type = getDesignatorType(incDesignatorStatement.getDesignator());
        	if(type != Tab.intType) {
        		report_error("Semanticka greska: Tip prilikom inkrementacije mora biti int", incDesignatorStatement);
        	}
    	}
    }
    
    @Override
    public void visit(FunctionCallStatement functionCallStatement) {
    	Obj func = Tab.find(functionCallStatement.getDesignator().getDesignator_name().getName());
    	if(func.getKind() != Obj.Meth) {
    		report_error("Semanticka greska: Ocekivana funkcija", functionCallStatement);
    	}
    }
    
    @Override
    public void visit(ReadStatement readStatement) {
    	if(Tab.find(readStatement.getDesignator().getDesignator_name().getName()).getKind() == Obj.Con
    		|| Tab.find(readStatement.getDesignator().getDesignator_name().getName()).getKind() == Obj.Meth) {
    		report_error("Semanticka greska: Nije dozvoljena dodela vrednosti", readStatement);
    	}
    	else {
    		Struct type = getDesignatorType(readStatement.getDesignator());
        	if(!builtInTypes.contains(type)) {
        		report_error("Semanticka greska: Tip prilikom dodele vrednosti mora biti int ili bool ili char", readStatement);
        	}
    	}
    }
    
    @Override
    public void visit(PrintStatement printStatement) {
    	if( !builtInTypes.contains(printStatement.getExpr().struct)) {
    		report_error("Semanticka greska: Tip prilikom ispisa mora biti int ili char ili bool", printStatement);
    	}
    }
    
    @Override
    public void visit(ReturnStatement returnStatement) {
    	if(returnStatement.getOpt_expresion() instanceof ReturnExpresion) {
    		if(currentRetType == null) {
    			report_error("Semanticka greska: Return izraz neocekivanog oblika", returnStatement);
    		}
    		else {
    			ReturnExpresion retExpr = (ReturnExpresion)returnStatement.getOpt_expresion();
        		if( currentRetType.getType() != retExpr.struct) {
        			report_error("Semanticka greska: Tip return izraza nije kompatibilan", returnStatement);
        		}
        		else {
        			hasReturnStmt = true;
        		}
    		}
    	}
    }
    
    @Override
    public void visit(ReturnExpresion returnExpresion) {
    	returnExpresion.struct = returnExpresion.getExpr().struct;
    }
    
    @Override
    public void visit(NegativeFactor nf) {
    	nf.struct = nf.getFactor().struct;
    }
}
