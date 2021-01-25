import org.junit.Test

import org.junit.Assert.*
import java.text.ParseException

class Tests {
    private fun impl(test: String) = Parser(test).parse()
    private fun testException(test: String) = assertTrue(
        try {
            println(impl(test))
            false
        } catch (e: ParseException) {
            println(e)
            true
        }
    )

    @Test
    fun `Test from the condition`() {
        val test = "((abc*b|a)*ab(aa|b*)b)*"
        printResult("results", "test_from_the_condition", test)
        println(impl(test))
    }

    @Test
    fun `Test ignoring blanks`() {
        val test = "(      ( a | b       ) | c  | d  )"
        println(impl("   a | a"))
        println(impl("(      ( a | b       ) | c  | d  )"))
        printResult("results", "test_kek", test)
    }

    @Test
    fun `Test selection`() {
        val test = "(x)(yz)"
        println(impl("a|a"))
        println(impl("a|(aa)"))
        println(impl("((a|b)|c|d)"))
        printResult("results", "test_selection", test)
    }

    @Test
    fun `Test concatenation`() {
        val test = "(x)(yz)"
        println(impl("a"))
        println(impl("aa"))
        println(impl("xyz"))
        println(impl(test))
        printResult("results", "test_concatenation", test)
    }

    @Test
    fun `Test Kleene closure`() {
        val test = "(x)|(y*z)*"
        println(impl("a*"))
        println(impl("a*a"))
        println(impl("(xyz)*"))
        println(impl(test))
        printResult("results", "test_kleene_closure", test)
    }

    @Test
    fun `Test unknown character`() {
        testException("a^")
        testException("a|b-c")
        testException("a|b +c")
    }

    @Test
    fun `Test empty parentheses`() {
        testException("()")
        testException("((()))()(())")
        testException("()()()")
    }

    @Test
    fun `Test wrong balance`() {
        testException("((((((")
        testException("(((((()")
        testException("))))))")
        testException("())))))")
        testException("((a)")
        testException("((a)))")
        testException("((a|b)*|c))")
    }

    @Test
    fun `Test unexpected token`() {
        testException("a|")
        testException("a()c")
        testException("*a")
    }
}