package org.jonas.jontability.Mapper;

import org.jonas.jontability.dto.BillDto;
import org.jonas.jontability.entities.BillEntity;
import org.jonas.jontability.entities.BasicEntity;
import org.jonas.jontability.persistence.AccountRepository;
import org.jonas.jontability.persistence.BillRepository;
import org.jonas.jontability.persistence.CategoryRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel="spring")
public interface BillMapper {
	BillMapper instance = Mappers.getMapper(BillMapper.class);

	BillDto toDto(BillEntity billEntity);

	@Mapping(target = "categoryEntity", ignore = true)
	@Mapping(target = "accountEntity", ignore = true)
	BillEntity toEntity(BillDto billDto, @Context CategoryRepository categoryRepo, @Context BillRepository billRepo, @Context AccountRepository accountRepo);

	@ObjectFactory
	default <T extends BasicEntity> T lookup(BillDto billDto, @Context CategoryRepository categoryRepo,
											  @Context BillRepository billRepo, @Context AccountRepository accountRepo, @TargetType Class<T> targetType) {
		BillEntity billEntity = billDto.getId() != null ? billRepo.findById(billDto.getId()).orElseGet(BillEntity::new) : new BillEntity();
		billEntity.setCategoryEntity(categoryRepo.findById(billDto.getCategoryId()).orElseThrow(IllegalArgumentException::new));
		billEntity.setAccountEntity(accountRepo.findById(billDto.getAccountId()).orElseThrow(IllegalArgumentException::new));
		return (T) billEntity;
	}
}
