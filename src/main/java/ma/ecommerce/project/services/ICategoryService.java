package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.CategoryDto;
import java.util.List;
public interface ICategoryService {

    List<CategoryDto> getCategories();

    void createCategory(CategoryDto categoryDto);

    void deleteCategory(Long categoryId);

    void updateCategory(Long id, CategoryDto categoryDto);
}
