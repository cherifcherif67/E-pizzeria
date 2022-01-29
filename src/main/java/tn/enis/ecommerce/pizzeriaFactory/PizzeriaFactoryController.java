package tn.enis.ecommerce.pizzeriaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzeriaFactory")
public class PizzeriaFactoryController {

    @Autowired
    PizzeriaFactoryService pizzeriaFactoryService;

    @GetMapping("/getAllPizzeriaFactory")
    public List<PizzeriaFactory> getAllPizzeriaFactory(){
        return pizzeriaFactoryService.getAllFactory();
    }

    @GetMapping("/getPizzeiaFactory/{idPizzeria}")
    public PizzeriaFactory getPizzeriaFactoryById(@PathVariable long idPizzeriaFactory){
        return pizzeriaFactoryService.getPizzeriaFactoryById(idPizzeriaFactory);
    }

    @GetMapping("/getPizzeriaFactorys/serach/location/{idPizzeriaFactoryLocation}")
    public List<PizzeriaFactory> getAllPizzeriaFactoryByLocationId(@PathVariable long idPizzeriaFactoryLocation){
        return pizzeriaFactoryService.getPizzeriaFactoryByLocationId(idPizzeriaFactoryLocation);
    }

    @PostMapping("/create/pizzeriaLocation/{idPizzeriaFactoryLocation}")
    public void createPizzeriaFactory(@RequestBody PizzeriaFactory pizzeriaFactoryToCreate,@PathVariable long idPizzeriaFactoryLocation){
        pizzeriaFactoryService.createPizzeriaFactory(pizzeriaFactoryToCreate,idPizzeriaFactoryLocation);
    }

    @PutMapping("/update/{idFactoryToUpdate}")
    public void setPizzeriaFactoryService(@PathVariable long idFactoryToUpdate,@RequestBody PizzeriaFactory pizzeriaFactoryUpdated){
        pizzeriaFactoryService.updatePizzeriaFactory(idFactoryToUpdate, pizzeriaFactoryUpdated);
    }

    @DeleteMapping("/deletePizzeriaFactory/{idPizzeriaFactoryToDelete}")
    public void deletePizzeriaFactoryById(@PathVariable long idPizzeriaFactoryToDelete){
        pizzeriaFactoryService.deletePizzeriaFactoryById(idPizzeriaFactoryToDelete);
    }
}
