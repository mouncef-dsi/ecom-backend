package ma.ecommerce.project.services;


import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.dto.CategoryDto;
import ma.ecommerce.project.entities.Address;
import ma.ecommerce.project.entities.Category;
import ma.ecommerce.project.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDto> getAddresses(){
        List<Address> addresses = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<AddressDto>();
        addresses.forEach(address -> addressDtos.add(new AddressDto(address.getStreet(),address.getCity())));
        return addressDtos;
    }

    public void createAddress(AddressDto addressDto){
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());

        addressRepository.save(address);
    }
}
