package ma.ecommerce.project.repositories;

import ma.ecommerce.project.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    // SPEL  spring expression language
    List<Address> findAddressByCity(String city);
}
