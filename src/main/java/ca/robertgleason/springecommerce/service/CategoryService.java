package ca.robertgleason.springecommerce.service;

import ca.robertgleason.springecommerce.model.Category;
import ca.robertgleason.springecommerce.payload.CategoryResponse;


public interface CategoryService {
    CategoryResponse getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    String updateCategory(Long categoryId, Category category);
}
