import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.ObjCMethod
import org.example.org.jetbrains.objcdiff.ObjCProperty
import org.example.org.jetbrains.objcdiff.parsers.*
import org.example.org.jetbrains.objcdiff.reports.parseType
import org.example.org.jetbrains.objcdiff.reports.toObjCTypes
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

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
        with(DiffContext()) {
            val decodeInt = "(int32_t)decodeInt".parseMethod()

            assertNotNull(decodeInt)

            assertEquals("decodeInt", decodeInt.name)
            assertNotNull(decodeInt.returnType)
            assertEquals("int32_t", decodeInt.returnType?.key)
        }
    }

    @Test
    fun `test parseProperty`() {
        with(DiffContext()) {
            val property = "@property (class, readonly) int64 getValue".parseProperty()
            assertNotNull(property)
            assertEquals("getValue", property.name)
            assertEquals("int64", property.type.key)
        }
    }

    @Test
    fun `test extractTypeValuePairs`() {
        assertEquals("(a) b".extractTypeValuePairs(), emptyList())
        assertEquals("(a)b".extractTypeValuePairs(), listOf("(a)b"))
        assertEquals("(a)b (c)d".extractTypeValuePairs(), listOf("(a)b", "(c)d"))
    }

    @Test
    fun `test complex generics`() {
        with(DiffContext()) {
            val symbolTitle =
                "@interface BooleanArraySerializer : PrimitiveArraySerializer<Boolean *, KotlinBooleanArray *, BooleanArrayBuilder *> <KSerializer>"
                    .parseObjCTypeHeader()

            val rawSuper = symbolTitle.rawSuper ?: error("rawSuper is null")
            val type = rawSuper.parseType()

            assertEquals("PrimitiveArraySerializer", type.name)
            assertEquals(
                listOf("Boolean", "KotlinBooleanArray", "BooleanArrayBuilder", "KSerializer"),
                type.generics.map { it.name })
        }
    }

    @Test
    fun `parse type`() {
        with(DiffContext()) {
            val type = "KotlinPair<__covariant A, __covariant B> ".parseType()
            assertEquals("KotlinPair", type.name)
            assertEquals(listOf("A", "B"), type.generics.map { it.name })
        }
    }

    @Test
    fun `parse header`() {
        val header = "@interface A: B".parseObjCTypeHeader()
        assertEquals("A", header.rawMain)
        assertEquals("B", header.rawSuper)
    }

    @Test
    fun `parse full type`() {
        with(DiffContext()) {
            val header = "@interface A<T>: B<V>".parseObjCTypeHeader()
            val type = parseType(header)

            assertEquals("A", type.key)
            assertEquals("T", type.generics.first().key)
            assertEquals("B", type.superType?.key)
            assertEquals("V", type.superType?.generics?.first()?.key)
        }

    }

    @Test
    fun `parse simple header`() {


        with(DiffContext()) {
            val types = """
            @interface A
            (int32_t)decodeInt
            @end
            @interface B: A
            @end
            @interface C: B
            @property (class, readonly) int64 getValue
            @end
        """.trimIndent().toObjCTypes().toList()

            assertEquals(3, types.size)

            val classA = types.first { it.key == "A" }
            val classB = types.first { it.key == "B" }
            val classC = types.first { it.key == "C" }

            assertNull(classA.superType)
            assertEquals("A", classB.superType?.key)
            assertEquals("B", classC.superType?.key)

            assertEquals(1, classA.members.size)
            assertTrue(classA.members.first() is ObjCMethod)
            assertEquals("decodeInt", (classA.members.first() as ObjCMethod).name)

            assertEquals(0, classB.members.size)

            assertEquals(1, classC.members.size)
            assertTrue(classC.members.first() is ObjCProperty)
            assertEquals("getValue", (classC.members.first() as ObjCProperty).name)
        }
    }
}