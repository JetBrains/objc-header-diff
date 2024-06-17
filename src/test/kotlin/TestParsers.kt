import org.example.org.jetbrains.objcdiff.parsers.*
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
        println("(int32_t)decodeInt".parseMethod())
        println("(Cargo)unloadCargo".parseMethod())
    }

    @Test
    fun `test extractTypeValuePairs`() {
        assertEquals("(a) b".extractTypeValuePairs(), emptyList())
        assertEquals("(a)b".extractTypeValuePairs(), listOf("(a)b"))
        assertEquals("(a)b (c)d".extractTypeValuePairs(), listOf("(a)b", "(c)d"))
    }

    @Test
    fun `test complex generics`() {
        val symbolTitle =
            "@interface BooleanArraySerializer : PrimitiveArraySerializer<Boolean *, KotlinBooleanArray *, BooleanArrayBuilder *> <KSerializer>"
                .parseSymbolTitle(
                    "interface"
                )

        val rawSuper = symbolTitle.rawSuper ?: error("rawSuper is null")
        val type = rawSuper.parseType()

        assertEquals("PrimitiveArraySerializer", type.name)
        assertEquals(
            listOf("Boolean", "KotlinBooleanArray", "BooleanArrayBuilder", "KSerializer"),
            type.generics.map { it.name })
    }

    @Test
    fun `parse type`() {
        val type = "KotlinPair<__covariant A, __covariant B> ".parseType()
        assertEquals("KotlinPair", type.name)
        assertEquals(listOf("A", "B"), type.generics.map {it.name})
    }
}