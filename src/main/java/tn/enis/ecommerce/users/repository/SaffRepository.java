package tn.enis.ecommerce.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.ecommerce.users.entity.Staff;

public interface SaffRepository extends JpaRepository<Staff,Long> {
}
