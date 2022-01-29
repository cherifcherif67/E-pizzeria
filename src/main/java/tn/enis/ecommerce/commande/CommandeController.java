package tn.enis.ecommerce.commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService ;

    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes(){
        return commandeService.getAllCommande();
    }

    @GetMapping("/getCommande/{idCommande}")
    public Commande getCommandeById(@PathVariable long idCommande){
        return commandeService.getCommandeById(idCommande);
    }

    @PostMapping("/getCommandes/search/pizzeriaFactory")
    public List<Commande> getCommandesByFactoryId(@RequestBody PizzeriaFactory pizzeriaFactory){
        return commandeService.getAllCommandeByPizzeriaFactory(pizzeriaFactory);
    }

    @GetMapping("/getCommandes/search/user/{idUser}")
    public List<Commande> getCommandesByUserId(@PathVariable long idUser){
        return commandeService.getAllCommandeOfUserByIdUser(idUser);
    }

    @GetMapping("/commandeAchived/{idCommandeToPass}")
    public void passCommande(@PathVariable long idCommandeToPass){
        commandeService.commandeAchived(idCommandeToPass);
        //ne9sa fazet notif lel client
    }

    @GetMapping("/commandeNotAchived/search/pizzeriaFactory/{pizzeriaFactoryId}")
    public List<Commande> getCommandesNotYetAchivedByIdPizzeriaFactory(@RequestBody long pizzeriaFactoryId){
        return commandeService.findCommandeNotYetReadyByFactory(pizzeriaFactoryId);
    }

    @PostMapping("/createCommande")
    public void createCommande(@RequestBody Commande commande){
        commandeService.createCommande(commande);
    }


    @PutMapping("/update/{idCommandeToUpdate}")
    public void updateCommande(@PathVariable long idCommandeToUpdate,@RequestBody Commande commandeUpdated){
        commandeService.setCommande(idCommandeToUpdate,commandeUpdated);
    }

    @DeleteMapping("/delete/{idCommandeToDelete}")
    public void deleteCommandeById(@PathVariable long idCommandeToDelete){
        commandeService.deleteCommandeById(idCommandeToDelete);
    }
}
