package com.sidharthr.oasisreader

class PageCleaner {

    fun getReadablePage(): String {
        return """
<html>
    Hello there!
</html>            
        """.trimIndent()
    }
}