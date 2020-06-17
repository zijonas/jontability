package org.jonas.jontability.business;

import org.jonas.jontability.PostFilter;
import org.jonas.jontability.business.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface IPostService extends IBasicService<PostDto> {
    Optional<List<PostDto>> getByFilter(PostFilter postFilter);

    Optional<List<Integer>> getAllYears();
}
