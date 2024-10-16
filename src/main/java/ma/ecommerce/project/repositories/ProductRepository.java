package ma.ecommerce.project.repositories;

import org.springframework.data.repository.query.Param;
import ma.ecommerce.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //List<Product> findProductByColor(String color);
    List<Product> findByColorIgnoreCase(String color);

    @Query("SELECT p FROM Product p WHERE LOWER(p.color) = LOWER(:color) AND LOWER(p.size) = LOWER(:size)")
    List<Product> getProductsByCriteriaIgnoreCase(@Param("color") String color, @Param("size") String size);

    @Query("SELECT p FROM Product p JOIN p.reviews r WHERE r.rating > :rating")
    List<Product> findProductsByReviewRatingGreaterThan(int rating);

}
