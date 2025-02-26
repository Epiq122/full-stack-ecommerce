package ca.robertgleason.springecommerce.controller;

import ca.robertgleason.springecommerce.model.Category;
import ca.robertgleason.springecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class CategoryController {
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryService categoryService;


    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category Added successfully";
    }
}
