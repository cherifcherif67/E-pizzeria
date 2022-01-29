package tn.enis.ecommerce.produit;

import lombok.Data;
import tn.enis.ecommerce.categorie.Categorie;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private float price;
    private String description;
    @ManyToOne
    private Categorie categorie;
    @ManyToMany
    private List<PizzeriaFactory> pizzeriaFactories;

}
