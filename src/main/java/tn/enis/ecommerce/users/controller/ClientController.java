package tn.enis.ecommerce.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.ecommerce.users.entity.Client;
import tn.enis.ecommerce.users.repository.ClientRepository;
import tn.enis.ecommerce.users.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/user/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAll")
    public List<Client> getAllClients(){
        return clientService.getAllClient();
    }

    @GetMapping ("/getClient/{clientId}")
    public Client getClientById(@PathVariable long clientId){
        return clientService.getClientById(clientId);
    }

    @GetMapping("/getClients/serach/name/{firstCaracteresOfName}")
    public List<Client> getClientsByNameStartingWith(@PathVariable String firstCaracteresOfName){
        return clientService.getClientsByNameStartingWith(firstCaracteresOfName);
    }

    @PostMapping("/create")
    public void createClient(@RequestBody Client client){
        clientService.createClient(client);
    }

    @PostMapping("/auth")
    public void clientAuthentificate(@RequestBody Client clientToAuthentificate){
        clientService.Authentificate(clientToAuthentificate);
    }

    @PutMapping("/update/{idClientToUpdate}")
    public void setClient(@PathVariable long idClientToUpdate,@RequestBody Client clientUpdated){
        clientService.setClient(idClientToUpdate,clientUpdated);
    }

    @DeleteMapping("/delete/{idClientToDelete}")
    public void deleteClient(@PathVariable long idClientToDelete){
        clientService.deleteClientById(idClientToDelete);
    }
}
