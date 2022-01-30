package tn.enis.ecommerce.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduirController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/getAll")
    public List<Produit> getAll(){
        return produitService.getAllProduits();
    }

    @GetMapping("/getProduitById/{produitId}")
    public Produit getProduitById(@PathVariable long produitId){
        return produitService.getProduitById(produitId);
    }

    @GetMapping("/getProduits/search/categorie/{categorieId}")
    public List<Produit> getProduitsByCategorieId(@PathVariable long categorieId){
        return produitService.getProduitsByCategorieId(categorieId);
    }

    @GetMapping("/getProduits/search/price/{minPrice}/{maxPrice}")
    public List<Produit> getProduitsByPrice(@PathVariable float minPrice,@PathVariable float maxPrice){
        return produitService.getProduitsFiltredByPrice(minPrice,maxPrice);
    }

    @GetMapping("/getProduits/search/nameStartingWith/{firstCaracteresOfName}")
    public List<Produit> getProduitsFiltredByName(@PathVariable String firstCaracteresOfName){
        return produitService.getProduitsByNameStartingWith(firstCaracteresOfName);
    }

    @PostMapping("/create")
    public void createProduit(@RequestBody Produit produitToCreate){
        produitService.createProduit(produitToCreate);
    }

    @PutMapping("/update/{idProduitToUpdate}")
    public void updateProduit(@PathVariable long idProduitToUpdate,@RequestBody Produit produitUpdated){
        produitService.setProduit(idProduitToUpdate,produitUpdated);
    }

    @DeleteMapping("/delete/{idProduitToDelete}")
    public void deleteProduitById(@PathVariable long idProduitToDelete){
        produitService.deleteProduitById(idProduitToDelete);
    }
}
