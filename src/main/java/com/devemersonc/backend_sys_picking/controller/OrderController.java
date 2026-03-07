package com.devemersonc.backend_sys_picking.controller;

import com.devemersonc.backend_sys_picking.DTO.orderDTO.CreateOrderDTO;
import com.devemersonc.backend_sys_picking.DTO.orderDTO.OrderResponseDTO;
import com.devemersonc.backend_sys_picking.model.Order;
import com.devemersonc.backend_sys_picking.service.orderService.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@Valid @RequestBody CreateOrderDTO createOrderDTO) {
        orderService.newOrder(createOrderDTO);
        return ResponseEntity.ok("Order creada con éxito");
    }
}
