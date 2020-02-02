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
import org.springframework.stereotype.Component
import java.util.*

@Component
@SpringBootTest
internal class BillConverterTest  {

    @Autowired
    var categoryRepository: CategoryRepository? = null

    @Autowired
    var billRepository: BillRepository? = null

    @Autowired
    var accountRepository: AccountRepository? = null

    @Test
    fun contextLoads() {
        val billDto = BillDto()
        billDto.categoryId = 1
        billDto.date = Date()
        billDto.accountId = 1
        billDto.value = 2.3
        billDto.description = "aisdiasd"

        val billEntity = BillMapper.instance.toEntity(billDto, categoryRepository, billRepository, accountRepository)

        Assertions.assertEquals(billDto.value, billEntity.value)
        Assertions.assertEquals(billDto.categoryId, billEntity.categoryEntity.id)
        Assertions.assertEquals(billDto.date, billEntity.date)
        Assertions.assertEquals(billDto.accountId, billEntity.accountEntity.id)
        Assertions.assertEquals(billDto.description, billEntity.description)
    }
}