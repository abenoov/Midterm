package kz.iitu.mukhtar.electricity.repository;

import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.Checkouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutsRepository extends JpaRepository<Checkouts, Long> {
    
}
