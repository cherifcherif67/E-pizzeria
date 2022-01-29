package tn.enis.ecommerce.pizzeriaLocation;

import lombok.Data;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PizzeriaLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String location;
    @OneToMany
    private List<PizzeriaFactory> pizzeriaFactoryList;
}
