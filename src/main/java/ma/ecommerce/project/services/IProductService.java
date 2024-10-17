package ma.ecommerce.project.services;


import ma.ecommerce.project.dto.ProductDto;
import ma.ecommerce.project.projection.ProductProjection;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProducts();

    List<ProductDto> getProductsByColor(String color);

    List<ProductDto> getProductsByCriteriaIgnoreCase(String color, String size);

    void createProduct(ProductDto productDto);

    void updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);

    List<ProductDto> getProductsByRatingGreaterThan(int rating);

    List<ProductProjection> getAllProductProjections(String name);
}
