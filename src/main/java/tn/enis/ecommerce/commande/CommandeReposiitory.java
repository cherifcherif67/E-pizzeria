package tn.enis.ecommerce.commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.ecommerce.pizzeriaFactory.PizzeriaFactory;

import java.util.List;

@Repository
public interface CommandeReposiitory extends JpaRepository<Commande,Long> {
    public List<Commande> findByUserId (long id);
    public List<Commande> findByPizzeriaFactory(PizzeriaFactory pizzeriaFactory);
    public List<Commande> findByIsReadyAndPizzeriaFactoryId(Boolean isReady, long pizzeriaFactory);

}
