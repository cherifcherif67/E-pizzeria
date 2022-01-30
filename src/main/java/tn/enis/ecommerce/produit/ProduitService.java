package tn.enis.ecommerce.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }

    public Produit getProduitById(long idProduit){
        if(produitRepository.findById(idProduit).isPresent()){
            return produitRepository.getById(idProduit);
        }
        return null;
    }

    public List<Produit> getProduitsByCategorieId(long categorieId){
        return produitRepository.findByCategorieId(categorieId);
    }

    public List<Produit> getProduitsByNameStartingWith(String firstCaracteresOfProduit){
        return produitRepository.findByNameStartingWith(firstCaracteresOfProduit);
    }

    public List<Produit> getProduitsFiltredByPrice(float minPrice,float maxPrice){
        return produitRepository.findByPriceBetween(minPrice,maxPrice);
    }

    public void createProduit(Produit produit){
        produitRepository.save(produit);
    }

    public void setProduit(long idProduitToUpdate,Produit produitUpdated){
        if (produitRepository.findById(idProduitToUpdate).isPresent()){
            Produit produitToUpdate = produitRepository.getById(idProduitToUpdate);
            produitToUpdate.setPrice(produitUpdated.getPrice());
            produitToUpdate.setDescription(produitUpdated.getDescription());
            produitToUpdate.setCategorie(produitUpdated.getCategorie());
            produitToUpdate.setName(produitUpdated.getName());
            produitToUpdate.setPizzeriaFactories(produitUpdated.getPizzeriaFactories());
            produitRepository.save(produitUpdated);
        }
    }

    public void deleteProduitById(long idProduitToDelete){
        if(produitRepository.findById(idProduitToDelete).isPresent()){
            produitRepository.deleteById(idProduitToDelete);
        }
    }
}
