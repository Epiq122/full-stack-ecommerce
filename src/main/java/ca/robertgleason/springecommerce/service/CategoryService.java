package ca.robertgleason.springecommerce.service;

import ca.robertgleason.springecommerce.model.Category;

import java.util.List;


public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    String updateCategory(Long categoryId, Category category);
}
