package org.jonas.jontability.business.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jonas.jontability.PostFilter;
import org.jonas.jontability.business.IPostService;
import org.jonas.jontability.business.dto.PostDto;
import org.jonas.jontability.business.mapper.PostMapper;
import org.jonas.jontability.persistence.AccountRepository;
import org.jonas.jontability.persistence.CategoryRepository;
import org.jonas.jontability.persistence.IPostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    private static final Logger log = LogManager.getLogger(PostService.class);

    private final IPostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;

    public PostService(IPostRepository postRepository, CategoryRepository categoryRepository, AccountRepository accountRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<List<PostDto>> getAll() {
        return Optional.of(postRepository.findAll().stream()
                .map(PostMapper.instance::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<PostDto>> getByFilter(PostFilter postFilter) {
        LocalDate dateStart = fromDateFromFilter(postFilter);
        LocalDate dateEnd = toDateFromFilter(postFilter);
        log.debug("Date From to: " + dateStart.toString() + '-' + dateEnd.toString());
        return Optional.of(
                postRepository.findByDateGreaterThanAndDateLessThan(dateStart, dateEnd).stream()
                        .map(PostMapper.instance::toDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Integer>> getAllYears() {
        return Optional.of(postRepository.distinctYears());
    }

    private LocalDate fromDateFromFilter(PostFilter postFilter) {
        int month = Month.JANUARY.getValue();
        if (postFilter.getMonth() != null) {
            month = postFilter.getMonth() + 1;
        }
        return LocalDate.of(postFilter.getYear(), month, 1);
    }

    private LocalDate toDateFromFilter(PostFilter postFilter) {
        int month = Month.DECEMBER.getValue();
        if (postFilter.getMonth() != null) {
            month = postFilter.getMonth() + 1;
        }
        LocalDate filterDate = LocalDate.of(postFilter.getYear(), month, 1);
        return filterDate.with(TemporalAdjusters.lastDayOfMonth());
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
