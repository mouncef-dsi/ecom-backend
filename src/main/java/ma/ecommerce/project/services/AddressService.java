package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.AddressDto;
import ma.ecommerce.project.entities.Address;
import ma.ecommerce.project.entities.Client;
import ma.ecommerce.project.repositories.AddressRepository;
import ma.ecommerce.project.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientRepository clientRepository;


    public AddressService() {
        System.out.println("hello");
    }

    public List<AddressDto> getAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<AddressDto>();
        addresses.forEach(address -> addressDtos.add(new AddressDto(address.getId(), address.getStreet(), address.getCity())));
        return addressDtos;
    }

    public List<AddressDto> getAddressesByCity(String city) {
        List<Address> addresses = addressRepository.findAddressByCity(city);
        List<AddressDto> addressDtos = new ArrayList<AddressDto>();
        addresses.forEach(address -> addressDtos.add(new AddressDto(address.getId(), address.getStreet(), address.getCity())));
        return addressDtos;
    }


    public void createAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());

        Optional<Client> clientOpt = clientRepository.findById(addressDto.getIdClient());
        if (clientOpt.isEmpty()) {
            throw new IllegalArgumentException("Le client avec l'identifiant " + addressDto.getIdClient() + " n'existe pas.");
        } else {
            Client client = clientOpt.get();
            address.setClient(client);
        }
        addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        if (addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
        } else {
            throw new IllegalArgumentException("L'adresse avec l'identifiant " + addressId + " n'existe pas.");
        }
    }

    public void updateAddress(Long id, AddressDto addressDto) {
        Optional<Address> existingAddress = addressRepository.findById(id);

        if (existingAddress.isPresent()) { // if address exists
            Address address = existingAddress.get();
            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            addressRepository.save(address);
        } else { // if address does not exist
            throw new IllegalArgumentException("L'adresse avec l'identifiant " + id + " n'existe pas.");
        }
    }
}
