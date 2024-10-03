package ma.ecommerce.project.services;


import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.entities.Address;
import ma.ecommerce.project.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDto> getAllAddresses() {
        List<Address> addresses= addressRepository.findAll();
        List<AddressDto> addressDtos= new ArrayList<>();
        addresses.forEach(adr->{
            AddressDto adrDto = new AddressDto(adr.getStreet(),adr.getCity());
            addressDtos.add(adrDto);
        });

        return addressDtos;
    }
}
