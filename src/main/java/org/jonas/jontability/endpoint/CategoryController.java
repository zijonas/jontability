package org.jonas.jontability.endpoint;

import org.jonas.jontability.business.impl.CategoryService;
import org.jonas.jontability.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value="/category")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.of(categoryService.getAll());
    }

    @PostMapping(value="/category")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
        System.out.println(categoryDto);
        return categoryService.persist(categoryDto);
    }

}
