package ca.robertgleason.springecommerce.repository;


import ca.robertgleason.springecommerce.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must be at least 5 characters") String categoryName);

}
