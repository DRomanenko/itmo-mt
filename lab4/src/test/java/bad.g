+p parsers.bad

|- s

s   : Tree := KLEENE c s1 {Tree("S", listOf(c, s1))}
           | SELECT c s1 {Tree("S", listOf(c, s1))}
           | LPAREN c s1 {Tree("S", listOf(c, s1))}
           | RPAREN c s1 {Tree("S", listOf(c, s1))}
           | LETTER c s1 {Tree("S", listOf(c, s1))};


s1  : Tree := SELECT c s1 {Tree("S'", listOf(Tree("|"), c, s1))}
           | KLEENE {Tree("Ɛ")}
           | LPAREN {Tree("Ɛ")}
           | RPAREN {Tree("Ɛ")}
           | LETTER {Tree("Ɛ")};


c   : Tree := KLEENE k c1 {Tree("C", listOf(k, c1))}
           | SELECT k c1 {Tree("C", listOf(k, c1))}
           | LPAREN k c1 {Tree("C", listOf(k, c1))}
           | RPAREN k c1 {Tree("C", listOf(k, c1))}
           | LETTER k c1 {Tree("C", listOf(k, c1))};


c1  : Tree := LETTER k c1 {Tree("C", listOf(k, c1))}
           | KLEENE {Tree("Ɛ")}
           | SELECT {Tree("Ɛ")}
           | LPAREN {Tree("Ɛ")}
           | RPAREN {Tree("Ɛ")};


k   : Tree := KLEENE r k1 {Tree("R", listOf(r, k1))}
           | SELECT r k1 {Tree("R", listOf(r, k1))}
           | LPAREN r k1 {Tree("R", listOf(r, k1))}
           | RPAREN r k1 {Tree("R", listOf(r, k1))}
           | LETTER r k1 {Tree("R", listOf(r, k1))};

k1  : Tree := KLEENE k1 {Tree("*", listOf(Tree("*"), k1))}
           | {Tree("Ɛ")};

r   : Tree := LPAREN s {Tree("R", listOf(Tree("("), s, Tree(")")))}
           | LETTER {Tree("LETTER")};

KLEENE      = "*";
SELECT      = "|";
LPAREN      = "(";
RPAREN      = ")";
LETTER      = '[a-z]+';
WHITESPACES => '\s+';