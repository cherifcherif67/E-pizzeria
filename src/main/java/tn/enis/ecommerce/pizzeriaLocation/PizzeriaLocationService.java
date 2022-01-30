package tn.enis.ecommerce.pizzeriaLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzeriaLocationService {

    @Autowired
    PizzeriaLocationRepository pizzeriaLocationRepository;

    public List<PizzeriaLocation> getAllPizzeriaFactoryLocation(){
        return pizzeriaLocationRepository.findAll();
    }

    public PizzeriaLocation getPizzeriaLocationById(long idPizzeriiaLocation){
        if(pizzeriaLocationRepository.findById(idPizzeriiaLocation).isPresent()){
            return pizzeriaLocationRepository.findById(idPizzeriiaLocation).get();
        }
        return null;
    }

    public void createPizzeriaLocation(PizzeriaLocation pizzeriaLocation){
        pizzeriaLocationRepository.save(pizzeriaLocation);
    }

    public void setPizzeriaLocation(long idPizzeriaLocationToUpdate,PizzeriaLocation pizzeriaLocationUpdated){
        if(pizzeriaLocationRepository.findById(idPizzeriaLocationToUpdate).isPresent()){
            PizzeriaLocation pizzeriaLocationToUpdated = pizzeriaLocationRepository.getById(idPizzeriaLocationToUpdate);
            pizzeriaLocationToUpdated.setLocation(pizzeriaLocationUpdated.getLocation());
            pizzeriaLocationRepository.save(pizzeriaLocationToUpdated);
        }
    }

    public void deletePizzeriaLocation(long idPizeeiraLocationToDelete){
        if(pizzeriaLocationRepository.findById(idPizeeiraLocationToDelete).isPresent()){
            pizzeriaLocationRepository.deleteById(idPizeeiraLocationToDelete);
        }
    }
}
