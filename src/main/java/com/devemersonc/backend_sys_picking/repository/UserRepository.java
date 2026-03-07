package com.devemersonc.backend_sys_picking.repository;

import com.devemersonc.backend_sys_picking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByRut(String rut);
    User findByUsername(String username);
}
