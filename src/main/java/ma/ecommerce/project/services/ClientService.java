package ma.ecommerce.project.services;


import ma.ecommerce.project.dto.ClientDto;
import ma.ecommerce.project.entities.Client;
import ma.ecommerce.project.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDto> getClients(){
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = new ArrayList<ClientDto>();
        clients.forEach(client -> clientDtos.add(new ClientDto(client.getName(),client.getEmail(),client.getPhone())));
        return clientDtos;
    }

    public void createClient(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        clientRepository.save(client);
    }

}
