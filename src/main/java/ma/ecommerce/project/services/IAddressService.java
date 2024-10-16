package ma.ecommerce.project.services;

import ma.ecommerce.project.dto.AddressDto;
import java.util.List;

public interface IAddressService {


    List<AddressDto> getAddresses();

    List<AddressDto> getAddressesByCity(String city);

    void createAddress(AddressDto addressDto);

    void deleteAddress(Long addressId);

    void updateAddress(Long id, AddressDto addressDto);
}
