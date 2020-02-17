package org.jonas.jontability

import org.jonas.jontability.imports.ExcelImportService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class JontabilityApplicationTests {
    @Autowired
    var excelImportService: ExcelImportService? = null

    @Test
    fun contextLoads() {
        excelImportService?.importFile("/home/jonas/Downloads/kk.csv", 2019)
    }
}