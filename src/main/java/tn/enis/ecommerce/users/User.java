package tn.enis.ecommerce.users;

import lombok.Data;
import tn.enis.ecommerce.commande.Commande;
import tn.enis.ecommerce.users.acheterBehaviour.AcheterBehaviour;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance

        (strategy

                = InheritanceType.SINGLE_TABLE
        )
@DiscriminatorColumn(name= "type_user", discriminatorType =
        DiscriminatorType.STRING)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String eMail;
    private int number;
    @OneToMany
    List<Commande> commandeList ;
}
