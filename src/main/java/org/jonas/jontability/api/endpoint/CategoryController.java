package org.jonas.jontability.api.endpoint;

import org.jonas.jontability.business.dto.CategoryDto;
import org.jonas.jontability.business.impl.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/category")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.of(categoryService.getAll());
    }

    @PostMapping(value = "/category")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryDto add(@RequestBody CategoryDto categoryDto) {
        return categoryService.persist(categoryDto);
    }

    @DeleteMapping(value = "/category/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            categoryService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }


}
