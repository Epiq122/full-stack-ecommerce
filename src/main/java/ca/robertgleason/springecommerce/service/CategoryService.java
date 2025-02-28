package ca.robertgleason.springecommerce.service;

import ca.robertgleason.springecommerce.model.Category;
import ca.robertgleason.springecommerce.payload.CategoryDTO;
import ca.robertgleason.springecommerce.payload.CategoryResponse;


public interface CategoryService {
    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDto);

    String deleteCategory(Long categoryId);

    String updateCategory(Long categoryId, Category category);
}
