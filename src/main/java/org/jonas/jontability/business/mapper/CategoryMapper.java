package org.jonas.jontability.business.mapper;

import org.jonas.jontability.business.dto.CategoryDto;
import org.jonas.jontability.persistence.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CategoryMapper extends BasicMapper<CategoryEntity, CategoryDto> {
	CategoryMapper instance = Mappers.getMapper(CategoryMapper.class);
}
