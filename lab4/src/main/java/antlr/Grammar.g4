grammar Grammar;

/*
 * Samples: https://www.antlr.org/
 * https://tomassetti.me/antlr-mega-tutorial/#chapter11
 */

/*
 * Parser Rules
 */
file : pckg? (start rulee+)? EOF;

start: '|-' NON_TERM;
pckg : '+p' PCKG_NAME;

rulee
	: parserRulee ';'
	| lexerRulee ';'
	;

parserRulee : NON_TERM inAttrs? (':' outAttr)? ':=' prods ('|' prods)*;

inAttrs : '<' param (',' param)* '>';
param : paramName ':' paramType;
paramType : TERM;
paramName : NON_TERM;
outAttr: TERM;

prods: prod*;
prod: NON_TERM args? | TERM | CODE;
args: '(' arg (',' arg)* ')';
arg : NON_TERM | TERM | CODE;

lexerRulee
	: TERM '=' term_value # tokenRule
	| TERM '=>' term_value # skipRule
	;

term_value
	: REGEX
	| STRING
	;

/*
 * Lexer Rules
 */
TERM        : ([A-Z])([0-9a-zA-Z])*;
NON_TERM    : ([a-z])([0-9a-zA-Z])*;

REGEX       : '\'' (~('\''|'\r' | '\n') | '\\\'')* '\'';
STRING      : '"' (~('"') | '\\"')* '"';

CODE        : '{' (~[{}]+ CODE?)* '}' ;
PCKG_NAME   : ([a-z0-9] | '.')+;

WHITESPACE  : [ \t\r\n]+ -> skip ;