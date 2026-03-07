package com.devemersonc.backend_sys_picking.service.orderService;

import com.devemersonc.backend_sys_picking.DTO.orderDTO.CreateOrderDTO;
import com.devemersonc.backend_sys_picking.DTO.orderDTO.OrderResponseDTO;
import com.devemersonc.backend_sys_picking.model.Order;
import com.devemersonc.backend_sys_picking.model.Product;
import com.devemersonc.backend_sys_picking.model.User;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderResponseDTO> getAllOrders();
    OrderResponseDTO getOrder(Long order_id);
    Order newOrder(CreateOrderDTO createOrderDTO);
    Order findOrderById(Long order_id);
}
