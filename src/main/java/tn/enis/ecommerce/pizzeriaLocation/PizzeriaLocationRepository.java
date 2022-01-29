package tn.enis.ecommerce.pizzeriaLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaLocationRepository extends JpaRepository<PizzeriaLocation,Long> {
}
