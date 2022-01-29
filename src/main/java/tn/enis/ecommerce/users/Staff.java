package tn.enis.ecommerce.users;

import tn.enis.ecommerce.grade.Grade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("staff")
public class Staff extends User{
    @ManyToOne
    private Grade grade;
}
