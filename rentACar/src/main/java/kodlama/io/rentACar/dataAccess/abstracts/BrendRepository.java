package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrendRepository extends JpaRepository<Brand, Integer>{
  boolean existsByName(String name);
}
