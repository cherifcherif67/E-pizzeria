package tn.enis.ecommerce.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.ecommerce.users.entity.Client;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    public Optional<Client> findByEmail(String email);
    public List<Client> findByNameStartingWith(String firstCaracteresOfName);
}
