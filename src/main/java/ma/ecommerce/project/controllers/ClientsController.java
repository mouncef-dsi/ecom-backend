package ma.ecommerce.project.controllers;
import org.springframework.http.ResponseEntity;
import ma.ecommerce.project.dto.ClientDto;
import ma.ecommerce.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService IClientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return IClientService.getClients();
    }

    @PostMapping
    public void addClient(@RequestBody ClientDto clientDto) {
        IClientService.createClient(clientDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            IClientService.deleteClient(id);
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussie
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si le client n'existe pas
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        try {
            IClientService.updateClient(id, clientDto);
            return ResponseEntity.ok("Client mis à jour avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
