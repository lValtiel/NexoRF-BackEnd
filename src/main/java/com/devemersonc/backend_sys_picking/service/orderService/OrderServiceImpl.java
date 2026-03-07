package com.devemersonc.backend_sys_picking.service.orderService;

import com.devemersonc.backend_sys_picking.DTO.orderDTO.CreateOrderDTO;
import com.devemersonc.backend_sys_picking.DTO.orderDTO.OrderResponseDTO;
import com.devemersonc.backend_sys_picking.DTO.orderDTO.ProductQuantityDTO;
import com.devemersonc.backend_sys_picking.exception.ResourceNotFoundException;
import com.devemersonc.backend_sys_picking.mapper.OrderMapper;
import com.devemersonc.backend_sys_picking.model.Order;
import com.devemersonc.backend_sys_picking.model.OrderLine;
import com.devemersonc.backend_sys_picking.model.Product;
import com.devemersonc.backend_sys_picking.repository.OrderRepository;
import com.devemersonc.backend_sys_picking.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDTOList(orders);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public OrderResponseDTO getOrder(Long order_id) {
        Order order = findOrderById(order_id);
        return orderMapper.toDTO(order);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public Order newOrder(CreateOrderDTO createOrderDTO) {
        Order order = new Order();
        order.setNumOrder(createOrderDTO.getNumOrder());
        order.setState(createOrderDTO.getState());

        List<OrderLine> lines = new ArrayList<>();
        for(ProductQuantityDTO pq : createOrderDTO.getProducts()) {
            Product product = productRepository.findById(pq.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado."));

            OrderLine line = new OrderLine();
            line.setProduct(product);
            line.setQuantity(pq.getQuantity());
            line.setOrder(order);
            line.setState("Pendiente");

            lines.add(line);
        }

        order.setOrderLines(lines);
        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(Long order_id) {
        Order order = orderRepository.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada."));
        return order;
    }
}
