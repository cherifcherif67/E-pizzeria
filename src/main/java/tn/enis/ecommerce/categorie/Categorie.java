package tn.enis.ecommerce.categorie;

import lombok.Data;
import tn.enis.ecommerce.produit.Produit;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    @OneToMany
    private List<Produit> produitList;

}
