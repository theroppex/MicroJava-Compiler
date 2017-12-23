package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.ArrayElementDesignatorList;
import rs.ac.bg.etf.pp1.ast.AsignDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.BoolConstFactor;
import rs.ac.bg.etf.pp1.ast.CharConstFactor;
import rs.ac.bg.etf.pp1.ast.ComplexFactorList;
import rs.ac.bg.etf.pp1.ast.ComplexTermList;
import rs.ac.bg.etf.pp1.ast.DecDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.Designator_name;
import rs.ac.bg.etf.pp1.ast.DivMulop;
import rs.ac.bg.etf.pp1.ast.EmptyPrintNumConst;
import rs.ac.bg.etf.pp1.ast.FunctionCallStatement;
import rs.ac.bg.etf.pp1.ast.FunctionResultNoParamFactor;
import rs.ac.bg.etf.pp1.ast.IncDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.MethodDeclaration;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.NegativeFactor;
import rs.ac.bg.etf.pp1.ast.NewArrayFactor;
import rs.ac.bg.etf.pp1.ast.NumericConstFactor;
import rs.ac.bg.etf.pp1.ast.PlusAdop;
import rs.ac.bg.etf.pp1.ast.PrintNumConst;
import rs.ac.bg.etf.pp1.ast.PrintStatement;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.ReturnStatement;
import rs.ac.bg.etf.pp1.ast.StarMulop;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VariableFactor;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor{
	private boolean errorDetected = false;
	
	private Logger log = Logger.getLogger(CodeGenerator.class);
	
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
	
	public boolean isErrorDetected() {
		return errorDetected;
	}
	
	@Override
	public void visit(Program program) {
		int nVars = 0;
		for(Obj o : program.obj.getLocalSymbols()) {
			if(o.getKind() == Obj.Var) {
				nVars++;
			}
		}
		report_info("Broj globalnih varijabli u programu " + nVars, program);
		Code.dataSize = nVars;
	}
	
	@Override
	public void visit(MethodName methodName) {
		if("main".equals(methodName.getName())) {
			Code.mainPc = Code.pc;
			report_info("PC main metode " + Code.mainPc, methodName);
		}
		methodName.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(0);
		int nMethVars = 0;
		for(Obj o : methodName.obj.getLocalSymbols()) {
			if(o.getKind() == Obj.Var) {
				nMethVars++;
			}
		}
		report_info("Metoda " + methodName.getName() + " ima " + nMethVars + " lokalnih varijabli", methodName);
		Code.put(nMethVars);
	}
	
	@Override
	public void visit(NumericConstFactor numericConstFactor) {
		Code.loadConst(numericConstFactor.getN1());
	}
	
	@Override
	public void visit(BoolConstFactor boolConstFactor) {
		if("true".equals(boolConstFactor.getB1())) {
			Code.loadConst(1);
		}
		else {
			Code.loadConst(1);
		}
	}
	
	@Override
	public void visit(CharConstFactor charConstFactor) {
		Code.loadConst(charConstFactor.getC1());
	}
	
	@Override
	public void visit(Designator_name dn) {
		Designator d = (Designator) dn.getParent();
		if(d.getDesignator_list() instanceof ArrayElementDesignatorList) {
			Obj save = new Obj(Obj.Var, "var", d.obj.getType().getElemType(), d.obj.getAdr(), d.obj.getLevel());
			Code.load(save);
		}
	}
	
	@Override
	public void visit(VariableFactor variableFactor) {
		Code.load(variableFactor.getDesignator().obj);
	}
	
	@Override
	public void visit(NewArrayFactor newArrayFactor) {
		Code.put(Code.newarray);
		if(newArrayFactor.getType().struct == Tab.charType) {
			Code.put(0);
		}
		else {
			Code.put(1);
		}
	}
	
	@Override
	public void visit(FunctionResultNoParamFactor fc) {
		int adr = fc.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(adr);
	}
	
	@Override
	public void visit(ComplexFactorList cfl) {
		if(cfl.getMulop() instanceof StarMulop) {
			Code.put(Code.mul);
		}
		else if(cfl.getMulop() instanceof DivMulop) {
			Code.put(Code.div);
		}
		else {
			Code.put(Code.rem);
		}
	}
	
	@Override
	public void visit(ComplexTermList ctl) {
		if(ctl.getAdop() instanceof PlusAdop) {
			Code.put(Code.add);
		}
		else {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(NegativeFactor nf) {
		Code.put(Code.neg);
	}
	
	@Override
	public void visit(AsignDesignatorStatement ads) {
		Code.store(ads.getDesignator().obj);
	}
	
	@Override
	public void visit(IncDesignatorStatement ids) {
		if(ids.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(ids.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(ids.getDesignator().obj);
	}
	
	@Override
	public void visit(DecDesignatorStatement dds) {
		if(dds.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(dds.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dds.getDesignator().obj);
	}
	
	@Override
	public void visit(FunctionCallStatement fcs) {
		int adr = fcs.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(adr);
		if (fcs.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}
	
	@Override
	public void visit(ReadStatement rs) {
		if(rs.getDesignator().obj.getType() == Tab.charType) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		Code.store(rs.getDesignator().obj);
	}
	
	@Override
	public void visit(PrintStatement ps) {
		if(ps.getOpt_num_const() instanceof EmptyPrintNumConst) {
			Code.loadConst(5);
		}
		else {
			int width = ((PrintNumConst)ps.getOpt_num_const()).getWidth();
			Code.loadConst(width);
		}
		
		if(ps.getExpr().struct == Tab.charType) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(ReturnStatement rs) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(MethodDeclaration md) {
		if(md.getMethod_name().obj.getType() == Tab.noType) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
		else {
			Code.put(Code.trap);
			Code.put(1);
		}
	}
}
