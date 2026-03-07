package com.devemersonc.backend_sys_picking.repository;

import com.devemersonc.backend_sys_picking.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySku(String sku);
    Product findByName(String name);
    Product findByLocation(String location);
}
