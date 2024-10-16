package ma.ecommerce.project.services;


import ma.ecommerce.project.dto.ClientDto;
import java.util.List;

public interface IClientService {

    List<ClientDto> getClients();

    void createClient(ClientDto clientDto);

    void deleteClient(Long clientId);

    void updateClient(Long id, ClientDto clientDto);
}

