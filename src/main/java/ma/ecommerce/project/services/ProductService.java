package ma.ecommerce.project.services;


import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.entities.Product;
import ma.ecommerce.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
