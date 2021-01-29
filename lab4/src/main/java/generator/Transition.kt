package generator

sealed class Transition {
    abstract val name: String
    data class Term(override val name: String) : Transition()
    data class NonTerm(override val name: String, val callAttrs: List<String>?) : Transition()
}