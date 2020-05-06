package kz.iitu.mukhtar.electricity.service;

import kz.iitu.mukhtar.electricity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
