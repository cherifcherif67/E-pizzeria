package tn.enis.ecommerce.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    public List<Produit> findByCategorieId(long categorieId);
    public List<Produit> findByNameStartingWith(String nameFirstCaracteres);
    public List<Produit> findByPriceBetween(float minPrice,float maxPrice);
}
