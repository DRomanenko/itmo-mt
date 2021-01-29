package generator

sealed class Gen {
    data class Casual(val elem: Transition) : Gen()
    data class Code(val code: String) : Gen()
}