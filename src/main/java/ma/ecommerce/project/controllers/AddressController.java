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
    private AddressService IAddressService;

    @GetMapping
    public List<AddressDto> getAddresses() {
        return IAddressService.getAddresses();
    }

    @GetMapping("/{city}")
    public List<AddressDto> getAddressesByCity(@PathVariable String city){
        return IAddressService.getAddressesByCity(city);
    }
    @PostMapping
    public void addAddress(@RequestBody AddressDto addressDto) {
        IAddressService.createAddress(addressDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        try {
            IAddressService.deleteAddress(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'adresse n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        try {
            IAddressService.updateAddress(id, addressDto);
            return ResponseEntity.ok("Adresse mise à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
