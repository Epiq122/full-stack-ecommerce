package ca.robertgleason.springecommerce.controller;

import ca.robertgleason.springecommerce.model.Category;
import ca.robertgleason.springecommerce.payload.CategoryResponse;
import ca.robertgleason.springecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categories = (CategoryResponse) categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }


    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @PathVariable Long categoryId, @RequestBody Category category) {
        String status = categoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
