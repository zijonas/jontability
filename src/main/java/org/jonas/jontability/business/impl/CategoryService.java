package org.jonas.jontability.business.impl;

import org.jonas.jontability.business.IBasicService;
import org.jonas.jontability.business.dto.CategoryDto;
import org.jonas.jontability.business.mapper.CategoryMapper;
import org.jonas.jontability.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements IBasicService<CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public Optional<List<CategoryDto>> getAll() {

        return Optional.of(categoryRepository.findAll().stream()
                .map(CategoryMapper.instance::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<CategoryDto> get(Integer id) {
        return Optional.of(CategoryMapper.instance.toDto(categoryRepository.findById(id).orElse(null)));
    }

    @Override
    public CategoryDto persist(CategoryDto categoryDto) {
        return CategoryMapper.instance.toDto(
                categoryRepository.save(
                        CategoryMapper.instance.toEntity(categoryDto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
