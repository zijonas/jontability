package org.jonas.jontability.business.impl;

import org.jonas.jontability.Mapper.PostMapper;
import org.jonas.jontability.business.IBasicService;
import org.jonas.jontability.dto.PostDto;
import org.jonas.jontability.persistence.AccountRepository;
import org.jonas.jontability.persistence.PostRepository;
import org.jonas.jontability.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IBasicService<PostDto> {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<List<PostDto>> getAll() {

        return Optional.of(postRepository.findAll().stream()
                .map(PostMapper.instance::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<PostDto> get(Integer id) {
        return Optional.of(PostMapper.instance.toDto(postRepository.findById(id).orElse(null)));
    }

    @Override
    public PostDto persist(PostDto postDto) {
        return PostMapper.instance.toDto(
                postRepository.save(
                        PostMapper.instance.toEntity(postDto, categoryRepository, postRepository, accountRepository)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }
}
