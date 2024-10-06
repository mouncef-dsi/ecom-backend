package ma.ecommerce.project.repositories;

import ma.ecommerce.project.entities.Address;
import ma.ecommerce.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //List<Product> findProductByColor(String color);
    List<Product> findByColorIgnoreCase(String color);
}
