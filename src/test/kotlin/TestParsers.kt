import org.example.org.jetbrains.objcdiff.parsers.extractTypeValuePairs
import org.example.org.jetbrains.objcdiff.parsers.parseMethod
import org.example.org.jetbrains.objcdiff.parsers.parseSuperType
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class TestParsers {

    @Test
    fun `test parseSuperType`() {
        assertEquals("A : B".parseSuperType(), "B")
        assertEquals("A:B".parseSuperType(), "B")
        assertEquals("A :B".parseSuperType(), "B")
        assertEquals("A: B".parseSuperType(), "B")
        assertEquals("A: B<C>".parseSuperType(), "B<C>")
        assertEquals("A: B<C*>".parseSuperType(), "B<C>")
    }

    @Test
    fun `test exception parseSuperType`() {
        assertThrows<IllegalArgumentException> {
            "@protocol A : B".parseSuperType()
        }
    }

    @Test
    fun `test parseMethod`() {
        //println(" void deliver(Cargo)".parseMethod())
        //println("(Cargo)unloadCargo".parseMethod())
        println("(int32_t)decodeInt".parseMethod())
        println("(Cargo)unloadCargo".parseMethod())
    }

    @Test
    fun `test extractTypeValuePairs`() {
        assertEquals("(a) b".extractTypeValuePairs(), emptyList())
        assertEquals("(a)b".extractTypeValuePairs(), listOf("(a)b"))
        assertEquals("(a)b (c)d".extractTypeValuePairs(), listOf("(a)b", "(c)d"))
    }
}