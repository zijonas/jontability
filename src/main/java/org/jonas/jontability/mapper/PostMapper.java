package org.jonas.jontability.mapper;

import org.jonas.jontability.dto.PostDto;
import org.jonas.jontability.entities.PostEntity;
import org.jonas.jontability.entities.BasicEntity;
import org.jonas.jontability.persistence.AccountRepository;
import org.jonas.jontability.persistence.PostRepository;
import org.jonas.jontability.persistence.CategoryRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel="spring")
public interface PostMapper {
	PostMapper instance = Mappers.getMapper(PostMapper.class);

	PostDto toDto(PostEntity postEntity);

	@Mapping(target = "categoryEntity", ignore = true)
	@Mapping(target = "accountEntity", ignore = true)
	PostEntity toEntity(PostDto postDto, @Context CategoryRepository categoryRepo, @Context PostRepository postRepo, @Context AccountRepository accountRepo);

	@ObjectFactory
	default <T extends BasicEntity> T lookup(PostDto postDto, @Context CategoryRepository categoryRepo,
											 @Context PostRepository postRepo, @Context AccountRepository accountRepo, @TargetType Class<T> targetType) {
		PostEntity postEntity = postDto.getId() != null ? postRepo.findById(postDto.getId()).orElseGet(PostEntity::new) : new PostEntity();
		postEntity.setCategoryEntity(categoryRepo.findById(postDto.getCategoryId()).orElseThrow(IllegalArgumentException::new));
		postEntity.setAccountEntity(accountRepo.findById(postDto.getAccountId()).orElseThrow(IllegalArgumentException::new));
		return (T) postEntity;
	}
}
