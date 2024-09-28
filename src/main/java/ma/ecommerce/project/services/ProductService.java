package ma.ecommerce.project.services;


import ma.ecommerce.project.entities.Product;
import ma.ecommerce.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}
