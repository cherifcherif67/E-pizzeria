package tn.enis.ecommerce.pizzeriaFactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzeriaFactoryRepository extends JpaRepository<PizzeriaFactory,Long> {
    public List<PizzeriaFactory> findByPizzeriaLocationId(long id);
}
