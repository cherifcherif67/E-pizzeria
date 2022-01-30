package tn.enis.ecommerce.commande;

import lombok.Data;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;
import tn.enis.ecommerce.produit.Produit;
import tn.enis.ecommerce.users.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Boolean isReady = false ;
    @ManyToOne
    private User user ;
    @ManyToOne
    private PizzeriaFactory pizzeriaFactory;
    @ManyToMany
    private List<Produit> commandeList ;

}
