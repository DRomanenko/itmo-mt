package generator

data class Transitions(val prods: List<Transition>, val gens: List<Gen>) : List<Transition> by prods
