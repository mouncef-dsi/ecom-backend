package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.entities.Product;
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


    public List<ProductDto> getProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        products.forEach(product -> productDtos.add(new ProductDto(product.getSize(),product.getColor(),product.getName())));
        return productDtos;
    }

    public void createProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setSize(productDto.getSize());
        product.setColor(productDto.getColor());
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
