package ma.ecommerce.project.controllers;

import ma.ecommerce.project.dto.ClientDto;
import ma.ecommerce.project.entities.Client;
import ma.ecommerce.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getClients();
    }
}
