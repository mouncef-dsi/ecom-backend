package ma.ecommerce.project.controllers;


import ma.ecommerce.project.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ma.ecommerce.project.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import ma.ecommerce.project.projection.ProductProjection;


import java.util.List;

@RestController // annotation
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {

        return productService.getProducts();
    }

    @GetMapping("/{color}")
    public List<ProductDto> getProductsByColor(@PathVariable String color){
        return productService.getProductsByColor(color);
    }

    @GetMapping("/{color}/{size}")
    public List<ProductDto> getProductsByCriteriaIgnoreCase(@PathVariable String color, @PathVariable String size){
        return productService.getProductsByCriteriaIgnoreCase(color,size);
    }



    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si le produit n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        try {
            productService.updateProduct(id, productDto);
            return ResponseEntity.ok("Produit mis à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-rating")
    public List<ProductDto> getProductsByRating(@RequestParam("rating") int rating) {
        return productService.getProductsByRatingGreaterThan(rating);
    }

    @GetMapping("/projections/{name}")
    public List<ProductProjection> getProductProjections(@PathVariable String name) {
        return productService.getAllProductProjections(name);
    }


}
