import org.example.org.jetbrains.objcdiff.ObjCType
import org.example.org.jetbrains.objcdiff.reports.collectClassesAndProtocols
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SearchTests {

    @Test
    fun noConnected() {
        val a = """
            @interface A
            @end
            
            @interface B
            @end
        """.trimIndent().collectClassesAndProtocols()
        val classA = a.first { it.key == "A" }
        val classB = a.first { it.key == "B" }

        assertFalse(areConnected(classA, classB))
    }

    @Test
    fun superConnected() {
        val a = """
            @interface A
            @end
            
            @interface B: A
            @end
        """.trimIndent().collectClassesAndProtocols()
        val classA = a.first { it.key == "A" }
        val classB = a.first { it.key == "B" }

        assertFalse(areConnected(classA, classB))
        assertTrue(areConnected(classB, classA))
    }

    @Test
    fun multiSuperConnected() {
        val a = """
            @interface A
            @end
            
            @interface B: A
            @end
            
            @interface C: B
            @end
        """.trimIndent().collectClassesAndProtocols()
        val classA = a.first { it.key == "A" }
        val classB = a.first { it.key == "B" }
        val classC = a.first { it.key == "C" }

        /**
         * Add cache and referencing
         */
        //assertFalse(areConnected(classA, classC))
        //assertTrue(areConnected(classB, classA))
        //assertTrue(areConnected(classC, classA))
    }
}

fun areConnected(from: ObjCType, to: ObjCType): Boolean {
    //if (from.type == to.type) return true
    //if (from.superType != null && from.superType == to.type) return true

    to.superType

    return false
}
