package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.entities.Address;
import ma.ecommerce.project.entities.Category;
import ma.ecommerce.project.entities.Client;
import ma.ecommerce.project.entities.Product;
import ma.ecommerce.project.repositories.CategoryRepository;
import ma.ecommerce.project.repositories.ClientRepository;
import ma.ecommerce.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public List<ProductDto> getProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        products.forEach(product -> productDtos.add(new ProductDto(product.getId(), product.getName(), product.getColor(), product.getSize())));
        return productDtos;
    }

    public List<ProductDto> getProductsByColor(String color) {
        List<Product> products = productRepository.findByColorIgnoreCase(color);
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        products.forEach(product -> productDtos.add(new ProductDto(product.getId(), product.getName(), product.getColor(), product.getSize())));
        return productDtos;
    }

    public void createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setColor(productDto.getColor());
        product.setSize(productDto.getSize());

        Optional<Category> categoryOpt = categoryRepository.findById(productDto.getIdCategory());
        if (categoryOpt.isEmpty()) {
            throw new IllegalArgumentException("Le client avec l'identifiant " + productDto.getIdCategory() + " n'existe pas.");
        } else {
            Category category = categoryOpt.get();
            product.setCategory(category);
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new IllegalArgumentException("Le produit avec l'identifiant " + productId + " n'existe pas.");
        }
    }

    public void updateProduct(Long id, ProductDto productDto) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(productDto.getName());
            product.setSize(productDto.getSize());
            product.setColor(productDto.getColor());
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Le produit avec l'identifiant " + id + " n'existe pas.");
        }
    }

}
