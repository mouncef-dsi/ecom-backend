package ma.ecommerce.project.controllers;
import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressDto> getAddresses() {
        return addressService.getAddresses();
    }
    @PostMapping
    public void addAddress(@RequestBody AddressDto addressDto) {
        addressService.createAddress(addressDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        try {
            addressService.deleteAddress(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'adresse n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        try {
            addressService.updateAddress(id, addressDto);
            return ResponseEntity.ok("Adresse mise à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
