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
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.of(categoryService.getAll());
    }

    @PostMapping(value="/category")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryDto add(@RequestBody CategoryDto categoryDto) {
        return categoryService.persist(categoryDto);
    }

    @DeleteMapping(value="/category/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Integer id) {
        try {
            categoryService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }


}
