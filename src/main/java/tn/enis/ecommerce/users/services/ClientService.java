package tn.enis.ecommerce.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.enis.ecommerce.users.entity.Client;
import tn.enis.ecommerce.users.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    public Client getClientById(long idClient){
        if(clientRepository.findById(idClient).isPresent()){
            return clientRepository.getById(idClient);
        }
        return null;
    }

    public void createClient(Client client){
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }

    public void setClient(long idClientToSet,Client clientUpdated){
        if(clientRepository.findById(idClientToSet).isPresent()){
            Client clientToUpdate = clientRepository.getById(idClientToSet);
            clientToUpdate.setEmail(clientUpdated.getEmail());
            clientToUpdate.setName(clientUpdated.getName());
            clientToUpdate.setNumber(clientUpdated.getNumber());
            clientRepository.save(clientToUpdate);
        }
    }

    public void deleteClientById(long idClientToDelete){
        if(clientRepository.findById(idClientToDelete).isPresent()){
            clientRepository.deleteById(idClientToDelete);
        }
    }

    public Client Authentificate(Client client){
        if(clientRepository.findByEmail(client.getEmail()).isPresent()){
            Client clientToAuth = clientRepository.findByEmail(client.getEmail()).get();
            if(passwordEncoder.matches(client.getPassword(),client.getPassword())){
                return clientToAuth;
            }
        }
        return null;
    }

    public List<Client> getClientsByNameStartingWith(String firstCaracteresOfName){
        return clientRepository.findByNameStartingWith(firstCaracteresOfName);
    }
}
