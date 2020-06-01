package org.jonas.jontability.endpoint;

import org.jonas.jontability.business.impl.PostService;
import org.jonas.jontability.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/post")
    public ResponseEntity<List<PostDto>> getAll(@RequestParam(required = false) Long from, @RequestParam(required = false) Long to) {
        if (from == null || to == null) {
            return ResponseEntity.of(postService.getAll());
        } else {
            return ResponseEntity.of(postService.getAllInRange(new Date(from), new Date(to)));
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
        try {
            postService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }

}
