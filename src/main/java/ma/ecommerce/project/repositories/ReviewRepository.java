package ma.ecommerce.project.repositories;

import ma.ecommerce.project.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {


}
