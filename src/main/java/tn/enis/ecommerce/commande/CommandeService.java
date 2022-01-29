package tn.enis.ecommerce.commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeReposiitory commandeReposiitory;

    public List<Commande> getAllCommandeOfUserByIdUser(long idUser){
        return commandeReposiitory.findByUserId(idUser);
    }

    public List<Commande> getAllCommandeByPizzeriaFactory(PizzeriaFactory pizzeriaFactory){
        return commandeReposiitory.findByPizzeriaFactory(pizzeriaFactory);
    }

    public Commande getCommandeById(long idCommande){
        return commandeReposiitory.findById(idCommande).get();
    }

    public List<Commande> getAllCommande(){
        return commandeReposiitory.findAll();
    }

    public void createCommande(Commande commande){
        commandeReposiitory.save(commande);
    }

    public void setCommande(long idCommandeToUpdate,Commande commandeUpdated){
        if(commandeReposiitory.findById(idCommandeToUpdate).isPresent()){
            Commande commandeToUpdate = commandeReposiitory.findById(idCommandeToUpdate).get();
            commandeToUpdate.setUser(commandeUpdated.getUser());
            commandeToUpdate.setPizzeriaFactory(commandeUpdated.getPizzeriaFactory());
            commandeToUpdate.setCommandeList(commandeUpdated.getCommandeList());
            commandeReposiitory.save(commandeToUpdate);
        }
    }

    public void deleteCommandeById(long idCommandeToDelete){
        if(commandeReposiitory.findById(idCommandeToDelete).isPresent()){
            commandeReposiitory.deleteById(idCommandeToDelete);
        }
    }

    public List<Commande> findCommandeNotYetReadyByFactory(long pizzeriaFactory){
        return commandeReposiitory.findByIsReadyAndPizzeriaFactoryId(false, pizzeriaFactory);
    }

    public void commandeAchived(long idCommande){
        if(commandeReposiitory.findById(idCommande).isPresent()){
            Commande commandeAchived = commandeReposiitory.getById(idCommande);
            commandeAchived.setIsReady(true);
            commandeReposiitory.save(commandeAchived);
        }
    }
}
