package com.devemersonc.backend_sys_picking.repository;

import com.devemersonc.backend_sys_picking.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
