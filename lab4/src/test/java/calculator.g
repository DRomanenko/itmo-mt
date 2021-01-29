+p parsers.calculator

|- pm

pm                  : Int := md pms(md) {pms};
pms <acc: Int>      : Int := PLUS md { val next = acc + md } pms(next) {pms}
                          | MINUS md { val next = acc - md } pms(next) {pms}
                          | {acc};

md                  : Int := shift mds(shift) {mds};
mds <acc: Int>      : Int := MUL shift mds({acc * shift}) {mds}
                          | DIV shift mds({acc / shift}) {mds}
                          | {acc};

shift               : Int := atom shifts(atom) {shifts};
shifts <acc: Int>   : Int := LSHIFT atom shifts({acc shl atom}) {shifts}
                          | RSHIFT atom shifts({acc ushr atom}) {shifts}
                          | {acc};

atom                : Int := LPAREN pm RPAREN {pm} | num {num};
num                 : Int := NUM {NUM.toInt()};

PLUS        = "+";
MINUS       = "-";
MUL         = "*";
DIV         = "/";
LSHIFT      = "<<";
RSHIFT      = ">>";
LPAREN      = "(";
RPAREN      = ")";
NUM         = '[0-9]+';
WHITESPACES => '\s+';