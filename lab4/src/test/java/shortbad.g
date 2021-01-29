+p parsers.shortbad

|- start

start : Tree := next PLUS {Tree("+", listOf(next))};

next : Tree := PLUS {Tree("+")}
            | EPS {Tree("")};

PLUS = "+";
EPS = "";
WHITESPACES => '\s+';
