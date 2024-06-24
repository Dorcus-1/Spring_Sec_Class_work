package rw.ac.rca.springsecurity1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca.springsecurity1.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {

}
