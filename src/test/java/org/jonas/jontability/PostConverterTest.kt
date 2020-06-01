package org.jonas.jontability

import org.jonas.jontability.mapper.PostMapper
import org.jonas.jontability.dto.PostDto
import org.jonas.jontability.persistence.AccountRepository
import org.jonas.jontability.persistence.PostRepository
import org.jonas.jontability.persistence.CategoryRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import java.util.*

@Component
@SpringBootTest
internal class PostConverterTest  {

    @Autowired
    var categoryRepository: CategoryRepository? = null

    @Autowired
    var postRepository: PostRepository? = null

    @Autowired
    var accountRepository: AccountRepository? = null

    @Test
    fun contextLoads() {
        val postDto = PostDto()
        postDto.categoryId = 1
        postDto.date = Date()
        postDto.accountId = 1
        postDto.value = 2.3
        postDto.description = "aisdiasd"

        val postEntity = PostMapper.instance.toEntity(postDto, categoryRepository, postRepository, accountRepository)

        Assertions.assertEquals(postDto.value, postEntity.value)
        Assertions.assertEquals(postDto.categoryId, postEntity.categoryEntity.id)
        Assertions.assertEquals(postDto.date, postEntity.date)
        Assertions.assertEquals(postDto.accountId, postEntity.accountEntity.id)
        Assertions.assertEquals(postDto.description, postEntity.description)
    }
}
