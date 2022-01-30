package tn.enis.ecommerce.users.entity;

import com.sun.xml.txw2.annotation.XmlCDATA;
import lombok.Data;
import javax.persistence.*;

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
    @Column(unique = true)
    private String email;
    private int number;
    private String password;

}
