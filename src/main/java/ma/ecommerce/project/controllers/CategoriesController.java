package ma.ecommerce.project.controllers;

import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.dto.CategoryDto;
import ma.ecommerce.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
    }
}
