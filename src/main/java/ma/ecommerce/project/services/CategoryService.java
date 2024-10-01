package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.CategoryDto;
import ma.ecommerce.project.entities.Category;
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
        List<Category> categories = categoryRepository.findAll(); // on execute la recherche et
        // on stock le resultat sur la variable categories

        /** on va mapper entre entité et dto**/
        List<CategoryDto> categoryDtos = new ArrayList<>(); // on crée une liste de type CategoryDto vide

        categories.forEach(category ->
            categoryDtos.add(new CategoryDto(category.getName(),category.getDescription())));
        return categoryDtos;
    }
}
