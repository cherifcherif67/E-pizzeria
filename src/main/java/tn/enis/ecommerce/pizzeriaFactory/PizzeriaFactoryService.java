package tn.enis.ecommerce.pizzeriaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.ecommerce.pizzeriaLocation.PizzeriaLocationService;

import java.util.List;

@Service
public class PizzeriaFactoryService {

    @Autowired
    PizzeriaFactoryRepository pizzeriaFactoryRepository;
    @Autowired
    PizzeriaLocationService pizzeriaLocationService;

    public List<PizzeriaFactory> getAllFactory(){
        return pizzeriaFactoryRepository.findAll();
    }

    public PizzeriaFactory getPizzeriaFactoryById(long idPizzeriaFactory){
        if(pizzeriaFactoryRepository.findById(idPizzeriaFactory).isPresent()){
            return pizzeriaFactoryRepository.getById(idPizzeriaFactory);
        }
        return null;
    }

    public List<PizzeriaFactory> getPizzeriaFactoryByLocationId(long idPizzeriaLocation){
        return pizzeriaFactoryRepository.findByPizzeriaLocationId(idPizzeriaLocation);
    }

    public void updatePizzeriaFactory(long idPizzeriaFactoryToUpdate, PizzeriaFactory pizzeriaFactoryUpdated){
        if(pizzeriaFactoryRepository.findById(idPizzeriaFactoryToUpdate).isPresent()){
            PizzeriaFactory pizzeriaFactoryToUpdate = pizzeriaFactoryRepository.getById(idPizzeriaFactoryToUpdate);
            pizzeriaFactoryToUpdate.setCommandeList(pizzeriaFactoryUpdated.getCommandeList());
            pizzeriaFactoryToUpdate.setCompteFacebook(pizzeriaFactoryUpdated.getCompteFacebook());
            pizzeriaFactoryToUpdate.setPizzeriaLocation(pizzeriaFactoryUpdated.getPizzeriaLocation());
            pizzeriaFactoryToUpdate.setDescription(pizzeriaFactoryUpdated.getDescription());
            pizzeriaFactoryToUpdate.setNumeroTel(pizzeriaFactoryUpdated.getNumeroTel());
            pizzeriaFactoryToUpdate.setProduitList(pizzeriaFactoryUpdated.getProduitList());
            pizzeriaFactoryRepository.save(pizzeriaFactoryToUpdate);
        }
    }

    public void deletePizzeriaFactoryById(long idPizzeriaFactoryById){
        if(pizzeriaFactoryRepository.findById(idPizzeriaFactoryById).isPresent()){
            pizzeriaFactoryRepository.deleteById(idPizzeriaFactoryById);
        }
    }

    public void createPizzeriaFactory(PizzeriaFactory pizzeriaFactory,long idPizzeriiaFactoryLocation){
        pizzeriaFactory.setPizzeriaLocation(pizzeriaLocationService.getPizzeriaLocationById(idPizzeriiaFactoryLocation));
        pizzeriaFactoryRepository.save(pizzeriaFactory);
    }
}
