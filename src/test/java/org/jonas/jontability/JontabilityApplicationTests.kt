package org.jonas.jontability

import org.jonas.jontability.Mapper.BillMapper
import org.jonas.jontability.dto.BillDto
import org.jonas.jontability.persistence.AccountRepository
import org.jonas.jontability.persistence.BillRepository
import org.jonas.jontability.persistence.CategoryRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
internal class JontabilityApplicationTests {
    @Autowired
    var categoryRepository: CategoryRepository? = null

    @Autowired
    var billRepository: BillRepository? = null

    @Autowired
    var accountRepository: AccountRepository? = null

    @Test
    fun contextLoads() {
//        val billDto = BillDto()
//        billDto.description = "asuhsad"
//        billDto.value = 23.33
//        billDto.date = Date()
//        billDto.categoryId = 2
//        val billEntity = BillMapper.instance.toEntity(billDto, categoryRepository, billRepository, accountRepository)
//        Assertions.assertEquals(billDto.categoryId, billEntity.categoryId)
//        Assertions.assertEquals(billDto.value, billEntity.value)
    }
}