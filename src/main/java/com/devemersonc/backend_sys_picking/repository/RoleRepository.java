package com.devemersonc.backend_sys_picking.repository;

import com.devemersonc.backend_sys_picking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    List<Role> findByName(String name);
}
