package tn.enis.ecommerce.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public List<Categorie> getAllCategorie(){
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long id){
        if(categorieRepository.findById(id).isPresent()){
            return categorieRepository.findById(id).get();
        }
        return null;
    }

    public void addCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public void setCategorie(long id,Categorie categorie){
        if(categorieRepository.findById(id).isPresent()){
            Categorie categorieToUpdate=categorieRepository.findById(id).get();
            categorieToUpdate.setDescription(categorie.getDescription());
            categorieToUpdate.setName(categorie.getName());
            categorieRepository.save(categorieToUpdate);
        }
    }

    public void deleteCategorieById(long id){
        if(categorieRepository.findById(id).isPresent()){
            categorieRepository.deleteById(id);
        }
    }
}
