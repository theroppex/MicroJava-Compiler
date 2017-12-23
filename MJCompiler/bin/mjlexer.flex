package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"+" 		{ return new_symbol(sym.PLUSOP, yytext()); }
"-"			{ return new_symbol(sym.MINUSOP, yytext()); }
"*"			{ return new_symbol(sym.STAROP, yytext()); }
"/"			{ return new_symbol(sym.DIVOP, yytext());}
"%"			{ return new_symbol(sym.MODOP, yytext()); }

"=="		{ return new_symbol(sym.BOOLEQUOP, yytext()); }
"!="		{ return new_symbol(sym.BOOLNEQUOP, yytext()); }
">"			{ return new_symbol(sym.BOOLGTOP, yytext()); }
">="		{ return new_symbol(sym.BOOLGTEOP, yytext()); }
"<"			{ return new_symbol(sym.BOOLSTOP, yytext()); }
"<="		{ return new_symbol(sym.BOOLSTEOP, yytext()); }
"&&"		{ return new_symbol(sym.BOOLANDOP, yytext()); }
"||"		{ return new_symbol(sym.BOOLOROP, yytext()); }

"="			{ return new_symbol(sym.ASNOP, yytext()); }

"++"		{ return new_symbol(sym.INCOP, yytext()); }
"--"		{ return new_symbol(sym.DECOP, yytext()); }

";"			{ return new_symbol(sym.SEMIOP, yytext()); }
","			{ return new_symbol(sym.COMMAOP, yytext()); }
"."			{ return new_symbol(sym.POINTOP, yytext()); }

"("			{ return new_symbol(sym.LBROP, yytext()); }
")"			{ return new_symbol(sym.RBROP, yytext()); }
"["			{ return new_symbol(sym.LSBROP, yytext()); }
"]"			{ return new_symbol(sym.RSBROP, yytext()); }
"{"			{ return new_symbol(sym.LVBROP, yytext()); }
"}"			{ return new_symbol(sym.RVBROP, yytext()); }

"program" 	{ return new_symbol(sym.PROG, yytext()); }
"break" 	{ return new_symbol(sym.BREAK, yytext()); }
"class"		{ return new_symbol(sym.CLASS, yytext()); }
"else"		{ return new_symbol(sym.ELSE, yytext()); }
"if"		{ return new_symbol(sym.IF, yytext()); }
"new"		{ return new_symbol(sym.NEWOP, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read" 		{ return new_symbol(sym.READ, yytext()); }
"return"	{ return new_symbol(sym.RETURN, yytext()); }
"void"		{ return new_symbol(sym.VOID, yytext()); }
"do"		{ return new_symbol(sym.DO, yytext()); }
"while"		{ return new_symbol(sym.WHILE, yytext()); }
"extends"	{ return new_symbol(sym.EXTENDS, yytext()); }
"const"		{ return new_symbol(sym.CONST, yytext()); }
"continue" 	{ return new_symbol(sym.CONTINUE, yytext()); }

"//"				{ yybegin(COMMENT); }
<COMMENT> .			{ yybegin(COMMENT); }
<COMMENT> "\r\n"	{ yybegin(YYINITIAL); }

[0-9]+							{ return new_symbol(sym.NUMCONST, new Integer(yytext())); }
"'"."'" 						{ return new_symbol(sym.CHARCONST, new Character(yytext().charAt(1))); }
"true" 							{ return new_symbol(sym.BOOLCONST, yytext()); }
"false" 						{ return new_symbol(sym.BOOLCONST, yytext()); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]*	{ return new_symbol (sym.IDENT, yytext()); }


. 								{ System.err.println("Leksicka greska (" + yytext() + ") u liniji " + (yyline + 1)); }