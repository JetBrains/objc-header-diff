import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.reports.buildReport
import java.io.File

fun main() {
    with(DiffContext(skipRefType = true)) {
        val actual = File("build/resources/main/actual.h")
        val expected = File("build/resources/main/expected.h")
        buildReport(actual, expected)
    }
}