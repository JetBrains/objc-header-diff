package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.reports.collectClassesAndProtocols
import org.jetbrains.objcdiff.utils.checkDependency
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SearchTests {

    @Test
    fun noConnected() {
        with(ObjCContext()) {
            val a = """
            @interface A
            @end
            
            @interface B
            @end
        """.trimIndent().collectClassesAndProtocols()
            val classA = a.first { it.key == "A" }
            val classB = a.first { it.key == "B" }

            assertFalse(checkDependency(classA, classB))
        }
    }

    @Test
    fun superConnected() {
        with(ObjCContext()) {
            val a = """
            @interface A
            @end
            
            @interface B: A
            @end
        """.trimIndent().collectClassesAndProtocols()
            val classA = a.first { it.key == "A" }
            val classB = a.first { it.key == "B" }

            assertFalse(checkDependency(classA, classB))
            assertTrue(checkDependency(classB, classA))
        }
    }

    @Test
    fun multiSuperConnected() {
        with(ObjCContext()) {
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

            assertFalse(checkDependency(classA, classC))
            assertTrue(checkDependency(classB, classA))
            assertTrue(checkDependency(classC, classA))
        }
    }

    @Test
    fun `basic property dependency`() {
        with(ObjCContext()) {
            val a = """
            @interface A
            @end
            
            @interface B
            @property A getA
            @end
        """.trimIndent().collectClassesAndProtocols()
            val classA = a.first { it.key == "A" }
            val classB = a.first { it.key == "B" }

            assertFalse(checkDependency(classA, classB))
            assertTrue(checkDependency(classB, classA))
        }
    }

    @Test
    fun `chain property dependency`() {
        with(ObjCContext()) {
            val a = """
            @interface A
            @end
            
            @interface B : A
            @end
            
            @interface C
            @property A getA
            @end
        """.trimIndent().collectClassesAndProtocols()
            val classA = a.first { it.key == "A" }
            val classB = a.first { it.key == "B" }
            val classC = a.first { it.key == "C" }

            assertFalse(checkDependency(classA, classB))
            assertTrue(checkDependency(classC, classA))
            assertFalse(checkDependency(classC, classB))
        }
    }
}

