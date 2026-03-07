package com.devemersonc.backend_sys_picking.DTO.orderDTO;

import com.devemersonc.backend_sys_picking.model.OrderLine;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({ "order_id", "numOrder", "createdAt", "state", "orderLines" })
public class OrderResponseDTO {
    private Long order_id;
    private String numOrder;
    private LocalDateTime createdAt;
    private String state;
    private List<OrderLineResponseDTO> orderLines;
}