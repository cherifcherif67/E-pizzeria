package tn.enis.ecommerce.pizzeriaLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzeriaLocation")
public class PizzeriaLocationController {

    @Autowired
    PizzeriaLocationService pizzeriaLocationService;

    @GetMapping("/getAll")
    public List<PizzeriaLocation> getAllPizzeriaLocation(){
        return pizzeriaLocationService.getAllPizzeriaFactoryLocation();
    }

    @GetMapping("/getPizzeriaLocationById/{idPizzeroaFactoryLocation}")
    public PizzeriaLocation getPizzeriaLocationById(@PathVariable long idPizzeroaFactoryLocation){
        return pizzeriaLocationService.getPizzeriaLocationById(idPizzeroaFactoryLocation);
    }

    @PostMapping("/create")
    public void createPizzeriaLocation(@RequestBody PizzeriaLocation pizzeriaLocation){
        pizzeriaLocationService.createPizzeriaLocation(pizzeriaLocation);
    }

    @PutMapping("/update/{idPizzeriaLocationToUpdate}")
    public void updatePizzeriaLocation(@PathVariable long idPizzeriaLocationToUpdate,@RequestBody PizzeriaLocation pizzeriaLocationUpdated){
        pizzeriaLocationService.setPizzeriaLocation(idPizzeriaLocationToUpdate,pizzeriaLocationUpdated);
    }

    @DeleteMapping("/delete/{idPizzeriaLocationToDelete}")
    public void deletePizzeriaLocationById(@PathVariable long idPizzeriaLocationToDelete){
        pizzeriaLocationService.deletePizzeriaLocation(idPizzeriaLocationToDelete);
    }
}
