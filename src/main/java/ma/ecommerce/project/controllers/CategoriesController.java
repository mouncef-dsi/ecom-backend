package ma.ecommerce.project.controllers;
import org.springframework.http.ResponseEntity;
import ma.ecommerce.project.dto.CategoryDto;
import ma.ecommerce.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping ("/categories")
public class CategoriesController {
    @Autowired
    private CategoryService ICategoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return ICategoryService.getCategories();
    }
    @PostMapping
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        ICategoryService.createCategory(categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            ICategoryService.deleteCategory(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si la catégorie n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        try {
            ICategoryService.updateCategory(id, categoryDto);
            return ResponseEntity.ok("Catégorie mise à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
