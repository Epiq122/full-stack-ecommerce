package ca.robertgleason.springecommerce.service;


import ca.robertgleason.springecommerce.model.Category;
import ca.robertgleason.springecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryServiceImpl implements CategoryService {
    //    private List<Category> categories = new ArrayList<>();
//    private Long nextId = 1L;


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Resource Not Found"));
        categoryRepository.deleteById(categoryId);
        return category.getCategoryName() + " deleted successfully";

    }

    @Override
    public String updateCategory(Long categoryId, Category category) {
        categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Resource Not Found"));
        Category savedCategory;


        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory.getCategoryName() + " updated successfully";
    }
}
