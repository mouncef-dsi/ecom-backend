package ma.ecommerce.project.controllers;

import ma.ecommerce.project.dto.CategoryDto;
import ma.ecommerce.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping ("/categories")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getCategories();
    }
}
