package rs.ac.bg.etf.pp1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class Compiler {
	private static Logger log = Logger.getLogger(Compiler.class);
	public static void main(String[] args) throws Exception {
		Options options = new Options();
		
		options.addOption("h", "help", false, "Prints help information");
		options.addOption("o", "out", true, "Path to the output file");
		options.addOption("i", "in", true, "Path to the input file");
		options.addOption("s", false, "Prints syntax tree");
		options.addOption("d", "dump", false, "Dumps symbol table ");
		
		CommandLineParser cp = new DefaultParser();
		CommandLine cl = null;
		
		try {
			cl = cp.parse(options, args);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		
		if(cl.hasOption("h")) {
			HelpFormatter hf = new HelpFormatter();
			hf.printHelp("MicroJava Compiler", options);
		}
		else {
			if( !cl.hasOption("i")) {
				log.error("Input file not specified");
				return;
			}
			
			if( !cl.hasOption("o")) {
				log.error("Output file not specified");
				return;
			}
			
			Yylex scanner = new Yylex(new FileReader(cl.getOptionValue("i")));
			
			MJParser parser = new MJParser(scanner);
			Program p = (Program)(parser.parse().value);
			
			if(cl.hasOption("s")) {
				System.out.println(p.toString(""));
			}
			
			System.out.println("===================Parsing completed===================");
			System.out.println("===================Semantic check started===============");
			
			Tab.init();
			Tab.insert(Obj.Type, "bool", new Struct(5));
			SemanticAnalyzer analyzer = new SemanticAnalyzer();
			p.traverseBottomUp(analyzer);
			
			System.out.println("===================Semantic check completed===============");
			
			if(cl.hasOption("d")) {
				AdvancedDumpVisitor dumpVisitor = new AdvancedDumpVisitor();
				Tab.dump(dumpVisitor);
				System.out.println("====================Sym Table Dump Completed====================");
			}
			
			if(analyzer.isErrorDetected()) {
				log.error("Semantic errors detected, compilation stopped");
				return;
			}
			else {
				CodeGenerator generator = new CodeGenerator();
				p.traverseBottomUp(generator);
				Code.write(new FileOutputStream(cl.getOptionValue("o")));
				System.out.println("====================Compilation Success====================");
			}
		}
	}
}
