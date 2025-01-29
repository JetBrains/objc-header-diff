package org.jetbrains.objcdiff.reports

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class Report {

    val date: String = LocalDateTime
        .now()
        .format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        )
}

