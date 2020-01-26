package org.jonas.jontability;

import org.jonas.jontability.Mapper.BillMapper;
import org.jonas.jontability.dto.BillDto;
import org.jonas.jontability.entities.BillEntity;
import org.jonas.jontability.persistence.BillRepository;
import org.jonas.jontability.persistence.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

@SpringBootTest
class JontabilityApplicationTests {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	BillRepository billRepository;

	@Test
	void contextLoads() {

		BillDto billDto = new BillDto();
		billDto.setDescription("asuhsad");
		billDto.setValue(23.33);
		billDto.setDate(new Date());
		billDto.setCategoryId(2);

		BillEntity billEntity = BillMapper.instance.toEntity(billDto, categoryRepository, billRepository);

		assertEquals(billDto.getCategoryId(), billEntity.getCategoryId());
		assertEquals(billDto.getValue(), billEntity.getValue());
	}

}
