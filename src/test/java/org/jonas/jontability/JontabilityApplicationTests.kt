package org.jonas.jontability

import org.jonas.jontability.persistence.AccountRepository
import org.jonas.jontability.persistence.PostRepository
import org.jonas.jontability.persistence.CategoryRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class JontabilityApplicationTests {
    @Autowired
    var categoryRepository: CategoryRepository? = null

    @Autowired
    var postRepository: PostRepository? = null

    @Autowired
    var accountRepository: AccountRepository? = null

    @Test
    fun contextLoads() {
    }
}