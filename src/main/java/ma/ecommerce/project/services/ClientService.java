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

    public List<ClientDto> getClients() {
        List<Client> clients = clientRepository.findAll(); // on execute la recherche et
        // on stock le resultat sur la variable categories

        /** on va mapper entre entité et dto**/
        List<ClientDto> clientDtos = new ArrayList<>(); // on crée une liste de type CategoryDto vide

        clients.forEach(client -> // LAMBDA EXPRESSION
                {
                    System.out.println(client);
                    ClientDto dto = new ClientDto(client.getName(), client.getEmail(), client.getPhone());
                    clientDtos.add(dto);
                }
        );


        return clientDtos;
    }

}
