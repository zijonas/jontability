package org.jonas.jontability

import org.jonas.jontability.Mapper.BillMapper
import org.jonas.jontability.dto.BillDto
import org.jonas.jontability.persistence.BillRepository
import org.jonas.jontability.persistence.CategoryRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import java.util.*

@Component
@SpringBootTest
internal class BillConverterTest  {

    @Autowired
    var categoryRepository: CategoryRepository? = null
    @Autowired
    var billRepository: BillRepository? = null

    @Test
    fun contextLoads() {
        val billDto = BillDto()
        billDto.categoryId = 2
        billDto.date = Date()
        billDto.accountId = 3
        billDto.value = 2.3

        val billEntity = BillMapper.instance.toEntity(billDto)

        Assertions.assertEquals(billDto.value, billEntity.value)
    }
}