package tn.enis.ecommerce.users.entity;

import tn.enis.ecommerce.grade.Grade;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("staff")
public class Staff extends User {
    @ManyToOne
    private Grade grade;
    @ManyToOne
    private PizzeriaFactory pizzeriaFactory;
}
