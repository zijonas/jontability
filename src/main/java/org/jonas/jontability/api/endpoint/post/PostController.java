package org.jonas.jontability.api.endpoint.post;

import org.jonas.jontability.PostFilter;
import org.jonas.jontability.business.IPostService;
import org.jonas.jontability.business.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/post/fetch")
    public ResponseEntity<List<PostDto>> fetch(@RequestBody PostFilter postFilter) {
        if (postFilter == null) {
            return ResponseEntity.of(postService.getAll());
        } else {
            return ResponseEntity.of(postService.getByFilter(postFilter));
        }
    }

    @PostMapping(value = "/post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostDto add(@RequestBody PostDto postDto) {
        System.out.println(postDto);
        return postService.persist(postDto);
    }

    @DeleteMapping(value = "/post/{id}")
    public void delete(@PathVariable Integer id) {
        postService.delete(id);
    }

    @GetMapping(value = "/post/years")
    public ResponseEntity<List<Integer>> getYears() {
        return ResponseEntity.of(postService.getAllYears());
    }
}
