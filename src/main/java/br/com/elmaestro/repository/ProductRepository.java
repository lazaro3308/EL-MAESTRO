package br.com.elmaestro.repository;
import br.com.elmaestro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product,Long>{
 List<Product> findByActiveTrueAndCategoryOrderByNameAsc(String category);
 Optional<Product> findBySlugAndActiveTrue(String slug);
 boolean existsBySlug(String slug);
}