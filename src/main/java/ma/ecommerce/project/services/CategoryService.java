package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.CategoryDto;
import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.entities.Category;
import ma.ecommerce.project.entities.Product;
import ma.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;




    public List<CategoryDto> getCategories(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
        categories.forEach(category -> categoryDtos.add(new CategoryDto(category.getName(),category.getDescription())));
        return categoryDtos;
    }

    public void createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        categoryRepository.save(category);
    }
}
