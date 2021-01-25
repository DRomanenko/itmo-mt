class Token(val type: Type, val letter: Char = '$') {
    enum class Type {
        LPAREN, RPAREN, SELECT, KLEENE, LETTER, END, OTHERWISE
    }
}