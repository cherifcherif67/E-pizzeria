package tn.enis.ecommerce.users.entity;



import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("client")
public class Client extends User {
}
