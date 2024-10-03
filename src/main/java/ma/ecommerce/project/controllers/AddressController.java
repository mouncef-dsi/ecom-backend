package ma.ecommerce.project.controllers;
import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.dto.ClientDto;
import ma.ecommerce.project.services.AddressService;
import ma.ecommerce.project.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
