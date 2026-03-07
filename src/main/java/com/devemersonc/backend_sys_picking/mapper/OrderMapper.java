package com.devemersonc.backend_sys_picking.mapper;

import com.devemersonc.backend_sys_picking.DTO.orderDTO.OrderLineResponseDTO;
import com.devemersonc.backend_sys_picking.DTO.orderDTO.OrderResponseDTO;
import com.devemersonc.backend_sys_picking.model.Order;
import com.devemersonc.backend_sys_picking.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "numOrder", source = "numOrder")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "orderLines", source = "orderLines")

    List<OrderResponseDTO> toDTOList(List<Order> orders);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "sku", source = "product.sku")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "location", source = "product.location")
    @Mapping(target = "state", source = "state")
    OrderLineResponseDTO toLineDTO(OrderLine line);

    List<OrderLineResponseDTO> toLineDTOList(List<OrderLine> lines);
    OrderResponseDTO toDTO(Order order);
}
