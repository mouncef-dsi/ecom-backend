package ma.ecommerce.project.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController // annotation
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService iproductService;

    @GetMapping
    public List<ProductDto> getProducts() {

        return iproductService.getProducts();
    }

    @GetMapping("/{color}")
    public List<ProductDto> getProductsByColor(@PathVariable String color){
        return iproductService.getProductsByColor(color);
    }

    @GetMapping("/{color}/{size}")
    public List<ProductDto> getProductsByCriteriaIgnoreCase(@PathVariable String color, @PathVariable String size){
        return iproductService.getProductsByCriteriaIgnoreCase(color,size);
    }



    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto) {
        iproductService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            iproductService.deleteProduct(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si le produit n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        try {
            iproductService.updateProduct(id, productDto);
            return ResponseEntity.ok("Produit mis à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-rating")
    public List<ProductDto> getProductsByRating(@RequestParam("rating") int rating) {
        return iproductService.getProductsByRatingGreaterThan(rating);
    }


}
