grammar Python;

/*
 * Samples: https://www.antlr.org/
 * https://tomassetti.me/antlr-mega-tutorial/#chapter11
 */

/*
 * Parser Rules
 */
prog: (structure)*;

structure: assign LINESEPARATOR
          | control
          ;

structures: (structure)+
          ;

assign: tabs
       (NAME ASSIGNMENT expr
      | NAME ASSIGNMENT INPUT
      | OUTPUT expr)
      ;

control: tabs IF cond COLON LINESEPARATOR structures (tabs ELSE COLON LINESEPARATOR structures)?
       ;

expr: LPAREN expr RPAREN
    | unary_op expr
    | expr bin_op expr
    | LITERAL
    | NAME
    ;

bin_op: PLUS
      | MINUS
      | MUL
      | DIV
      ;

unary_op: PLUS
        | MINUS
        ;

cond: LPAREN cond RPAREN
    | expr cond_op expr
    | LITERAL
    | NAME
    ;

cond_op: EQ
       | NEQ
       | GT
       | LT
       | GEQ
       | LEQ
       ;

tabs: TAB*;

/*
 * Lexer Rules
 */

/* Python control structures */
IF              : 'if';
ELSE            : 'else';

/* Python (in/out)put */
INPUT           : 'int(input())';
OUTPUT          : 'print';

/* Python assignment */
ASSIGNMENT      : '=';
LITERAL         : ([0-9])+;
NAME            : ([a-zA-Z_])([0-9a-zA-Z_])*;

/* Python braces */
COLON           : ':';
LPAREN          : '(';
RPAREN          : ')';

/* Python arithmetic operators */
PLUS            : '+';
MINUS           : '-';
MUL             : '*';
DIV             : '/';

/* Python comparison operators
 * https://pythonru.com/uroki/operatory-v-python-uroki-po-python-dlja-nachinajushhih
 */
EQ              : '==';
NEQ             : '!=';
GT              : '>';
LT              : '<';
GEQ             : '>=';
LEQ             : '<=';

/* Python separators */
TAB             : [\t];
WHITESPACE      : ' '+ -> skip;
LINESEPARATOR   : [\r\n]+;