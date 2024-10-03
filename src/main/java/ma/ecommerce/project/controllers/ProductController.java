package ma.ecommerce.project.controllers;


import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.entities.Product;
import ma.ecommerce.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
