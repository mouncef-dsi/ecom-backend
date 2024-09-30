package ma.ecommerce.project.services;

import ma.ecommerce.project.entities.Category;
import ma.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
