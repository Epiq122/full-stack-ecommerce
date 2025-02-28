package ca.robertgleason.springecommerce.service;


import ca.robertgleason.springecommerce.exceptions.APIException;
import ca.robertgleason.springecommerce.exceptions.ResourceNotFoundException;
import ca.robertgleason.springecommerce.model.Category;
import ca.robertgleason.springecommerce.payload.CategoryDTO;
import ca.robertgleason.springecommerce.payload.CategoryResponse;
import ca.robertgleason.springecommerce.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("No categories found");
        }
        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse; // ✅ Correct return type
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with name " + category.getCategoryName() + " already exists");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepository.deleteById(categoryId);
        return category.getCategoryName() + " deleted successfully";

    }

    @Override
    public String updateCategory(Long categoryId, Category category) {
        categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        Category savedCategory;


        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory.getCategoryName() + " updated successfully";
    }
}
