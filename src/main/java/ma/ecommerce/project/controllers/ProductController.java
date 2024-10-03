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
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
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


}
