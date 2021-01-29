package generator

data class Assignments(
    val name: String,
    var transitions: List<Transitions> = ArrayList(),
    var returnType: String? = null,
    var args: List<Pair<String, String>>? = null
) {
    fun checkArgs() = args?.joinToString { (n, t) -> "$n: $t" }.orEmpty()
}