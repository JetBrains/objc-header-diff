import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.reports.collectClassesAndProtocols
import org.example.org.jetbrains.objcdiff.utils.areConnected
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SearchTests {

    @Test
    fun noConnected() {
        with(DiffContext()) {
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
    }

    @Test
    fun superConnected() {
        with(DiffContext()) {
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
    }

    @Test
    fun multiSuperConnected() {
        with(DiffContext()) {
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

            assertFalse(areConnected(classA, classC))
            assertTrue(areConnected(classB, classA))
            assertTrue(areConnected(classC, classA))
        }
    }
}

