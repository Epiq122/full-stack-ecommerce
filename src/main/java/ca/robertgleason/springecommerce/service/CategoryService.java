package ca.robertgleason.springecommerce.service;

import ca.robertgleason.springecommerce.payload.CategoryDTO;
import ca.robertgleason.springecommerce.payload.CategoryResponse;


public interface CategoryService {
    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDto);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
