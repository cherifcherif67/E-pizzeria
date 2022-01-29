package tn.enis.ecommerce.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("getAllCategories")
    public List<Categorie> getAllCategories(){
        return categorieService.getAllCategorie();
    }

    @GetMapping("getCategrie/{id}")
    public Categorie getCategorieById(@PathVariable long id){
        return categorieService.getCategorieById(id);
    }

    @PostMapping("create")
    public void addCategorie(@RequestBody Categorie categorie){
        categorieService.addCategorie(categorie);
    }

    @PutMapping("/update/{idCategoorieToUpdate}")
    public void updateCategorie(@PathVariable long idCategoorieToUpdate,@RequestBody Categorie categorieUpdate){
        categorieService.setCategorie(idCategoorieToUpdate,categorieUpdate);
    }

    @DeleteMapping("/delete/{idCategorieToDelete}")
    public void deleteCategorie(@PathVariable long idCategorieToDelete){
        categorieService.deleteCategorieById(idCategorieToDelete);
    }
}
