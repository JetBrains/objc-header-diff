package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.*
import org.jetbrains.objcdiff.reports.buildObjectType
import org.jetbrains.objcdiff.utils.getFirstObjCObject
import org.jetbrains.objcdiff.utils.parseObjCObjects
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
        with(ObjCContext()) {
            val decodeInt = "+ (void) decodeInt(int32_t)value".parseMethod()

            assertNotNull(decodeInt)

            assertEquals("decodeInt", decodeInt.name)
            assertNotNull(decodeInt.returnType)
            assertEquals("void", decodeInt.returnType?.key)
        }
    }

    @Test
    fun `test parseProperty`() {
        with(ObjCContext()) {
            val property = "@property (class, readonly) int64_t getValue".parseProperty()
            assertNotNull(property)
            assertEquals("getValue", property.name)
            assertEquals("int64_t", property.type.key)
        }
    }

    @Test
    @Ignore //verify if the definition of KSerializer is valid
    fun `test complex generics`() {
        with(ObjCContext()) {
            val symbolTitle =
                "@interface BooleanArraySerializer : PrimitiveArraySerializer<Boolean *, KotlinBooleanArray *, BooleanArrayBuilder *> <KSerializer>"
                    .parseObjCTypeHeader()

            val rawSuper = symbolTitle.rawSuper ?: error("rawSuper is null")
            val type = rawSuper.parseObjCType() as ObjCType.ObjectType

            assertEquals("PrimitiveArraySerializer", type.name)
            assertEquals(
                listOf("Boolean", "KotlinBooleanArray", "BooleanArrayBuilder", "KSerializer"),
                type.generics.map { it.name })
        }
    }

    @Test
    fun `parse type`() {
        with(ObjCContext()) {
            val type = "KotlinPair<__covariant A, __covariant B> ".parseObjCType() as ObjCType.ObjectType
            assertEquals("KotlinPair", type.name)
            assertEquals(listOf("A", "B"), type.generics.map { it.name })
        }
    }

    @Test
    fun `parse multiple generics`() {
        with(ObjCContext()) {
            val type = "A<B, C>".parseObjCType() as ObjCType.ObjectType
            assertEquals("A", type.name)
            assertEquals(listOf("B", "C"), type.generics.map { it.name })
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
        with(ObjCContext()) {
            val header = "@interface A<T>: B<V>".parseObjCTypeHeader()
            val type = buildObjectType(header)

            assertEquals("A", type.key)
            assertEquals("T", type.generics.first().key)
            assertEquals("B", type.superType?.key)
            assertEquals("V", type.superType?.getGenericsOrNull()?.first()?.key)
        }

    }

    @Test
    fun `parse simple header`() {


        with(ObjCContext()) {
            val types = """
            @interface A
            + (void) decode(int32_t)decodeInt
            @end
            @interface B: A
            @end
            @interface C: B
            @property (class, readonly) int64 getValue
            @end
        """.parseObjCObjects()

            assertEquals(3, types.size)

            val classA = types.first { it.key == "A" }
            val classB = types.first { it.key == "B" }
            val classC = types.first { it.key == "C" }

            assertNull(classA.superType)
            assertEquals("A", classB.superType?.key)
            assertEquals("B", classC.superType?.key)

            assertEquals(1, classA.members.size)
            assertTrue(classA.members.first() is ObjCMethod)
            assertEquals("decode", (classA.members.first() as ObjCMethod).name)

            assertEquals(0, classB.members.size)

            assertEquals(1, classC.members.size)
            assertTrue(classC.members.first() is ObjCProperty)
            assertEquals("getValue", (classC.members.first() as ObjCProperty).name)
        }
    }

    @Test
    fun zzz() {
    }

    fun foo() {
        getInt(Any() as Zed)
    }

    fun getInt(i: Zed) {

    }

    interface Zed

    @Test
    fun `parse kotlin array`() {

        with(ObjCContext()) {
            """
            @interface KotlinArray<T> : Base
            + (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(Int *))init __attribute__((swift_name("init(size:init:)")));
            + (instancetype)alloc __attribute__((unavailable));
            + (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
            - (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
            - (id<KotlinIterator>)iterator __attribute__((swift_name("iterator()")));
            - (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
            @property (readonly) int32_t size __attribute__((swift_name("size")));
            @end
        """.getFirstObjCObject()
        }
    }

    @Test
    fun `split basic selectors`() {
        assertEquals(
            listOf(SelectorItem("A", "B", "C"), SelectorItem("X", "Y", "Z")),
            splitSelectors("A:(B)C X:(Y)Z")
        )
    }

    @Test
    fun `split function type selectors`() {
        assertEquals(
            listOf(
                SelectorItem("arrayWithSize", "int32_t", "size"),
                SelectorItem("init", "T _Nullable (^)(Int *)", "init")
            ),
            splitSelectors("arrayWithSize:(int32_t)size init:(T _Nullable (^)(Int *))init")
        )
    }

    @Test
    fun `single generic with space`() {
        with(ObjCContext()) {
            val type = "DateTimeFormatBuilderWithDate <DateTimeFormatBuilder>".parseObjCType()
            println(type)
        }
    }

    @Test
    fun `extension type`() {
        with(ObjCContext()) {
            val type = "DatePeriod (Extensions)".parseObjCType()
            println(type)
        }
    }

    @Test
    fun `temp x`() {
        val source = """
            - (NSString *)formatToStringValue:(int64_t)value unit_:(NSString *)unit __attribute__((swift_name("formatToString(value:unit_:)")));
        """.trimIndent()

        with(ObjCContext()) {
            val type = source.parseMethod()
            println(type)
        }
    }
}