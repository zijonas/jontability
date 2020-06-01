package org.jonas.jontability.mapper;

import org.jonas.jontability.dto.CategoryDto;
import org.jonas.jontability.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CategoryMapper extends BasicMapper<CategoryEntity, CategoryDto> {
	CategoryMapper instance = Mappers.getMapper(CategoryMapper.class);
}
