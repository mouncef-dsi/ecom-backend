package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.entities.Address;
import ma.ecommerce.project.repositories.AddressRepository;
import ma.ecommerce.project.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceUpdated implements IAddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<AddressDto> getAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<AddressDto>();
        addresses.forEach(address -> addressDtos.add(new AddressDto(address.getId(), address.getStreet()+"MA", address.getCity())));
        return addressDtos;
    }

    @Override
    public List<AddressDto> getAddressesByCity(String city) {
        return List.of();
    }

    @Override
    public void createAddress(AddressDto addressDto) {

    }

    @Override
    public void updateAddress(Long id, AddressDto addressDto) {

    }

    @Override
    public void deleteAddress(Long addressId) {

    }
}
