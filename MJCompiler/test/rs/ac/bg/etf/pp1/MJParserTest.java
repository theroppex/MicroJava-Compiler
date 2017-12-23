package rs.ac.bg.etf.pp1;

import java.io.FileOutputStream;
import java.io.FileReader;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class MJParserTest {
	
	public static void main(String[] args) throws Exception {
			FileReader r = new FileReader("test/test1.mj");
			Yylex skener = new Yylex(r);
			MJParser p = new MJParser(skener);
			Symbol s = p.parse();
			
			Program prog = (Program)(s.value);

			// ispis sintaksnog stabla
			// System.out.println(prog.toString(""));
			System.out.println("===============================================================");
			
			Tab.init();
			Tab.insert(Obj.Type, "bool", new Struct(5));
			SemanticAnalyzer analyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(analyzer);
			
			DumpSymbolTableVisitor vis = new DumpSymbolTableVisitor() {
				@Override
				public void visitStructNode(Struct structToVisit) {
					switch (structToVisit.getKind()) {
					case Struct.None:
						output.append("notype");
						break;
					case Struct.Int:
						output.append("int");
						break;
					case Struct.Char:
						output.append("char");
						break;
					//Dodat ispis za bool
					case 5:
						output.append("bool");
						break;
					case Struct.Array:
						output.append("Arr of ");
						
						switch (structToVisit.getElemType().getKind()) {
						case Struct.None:
							output.append("notype");
							break;
						case Struct.Int:
							output.append("int");
							break;
						case Struct.Char:
							output.append("char");
							break;
						case Struct.Class:
							output.append("Class");
							break;
						case 5:
							output.append("bool");
							break;
						}
						break;
					case Struct.Class:
						output.append("Class [");
						for (Obj obj : structToVisit.getMembers().symbols()) {
							obj.accept(this);
						}
						output.append("]");
						break;
					}
				}
			};
			Tab.dump(vis);
			if( !analyzer.isErrorDetected()) {
				CodeGenerator generator = new CodeGenerator();
				prog.traverseBottomUp(generator);
				Code.write(new FileOutputStream("test/test1.obj"));
			}
	}
}
