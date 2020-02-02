package org.jonas.jontability.endpoint;

import org.jonas.jontability.business.impl.PostService;
import org.jonas.jontability.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value="/post")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<PostDto>> getAll() {
        return ResponseEntity.of(postService.getAll());
    }

    @PostMapping(value="/post")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostDto addBill(@RequestBody PostDto postDto) {
        System.out.println(postDto);
        return postService.persist(postDto);
    }

    @DeleteMapping(value="/post/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Integer id) {
        try {
            postService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }

}
