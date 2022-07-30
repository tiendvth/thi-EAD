package fpt.aptech.thieaddangvantien.repository;

import fpt.aptech.thieaddangvantien.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
