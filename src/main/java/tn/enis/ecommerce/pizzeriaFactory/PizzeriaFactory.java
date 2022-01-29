package tn.enis.ecommerce.pizzeriaFactory;

import lombok.Data;
import tn.enis.ecommerce.commande.Commande;
import tn.enis.ecommerce.pizzeriaLocation.PizzeriaLocation;
import tn.enis.ecommerce.produit.Produit;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PizzeriaFactory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description ;
    private int numeroTel;
    private String compteFacebook;
    @ManyToOne
    private PizzeriaLocation pizzeriaLocation;
    @OneToMany
    private List<Commande> commandeList;
    @ManyToMany
    private List<Produit> produitList;

}
