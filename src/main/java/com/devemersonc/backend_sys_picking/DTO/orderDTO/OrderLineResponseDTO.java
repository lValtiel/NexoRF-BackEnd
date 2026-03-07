package com.devemersonc.backend_sys_picking.DTO.orderDTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "product_Id", "sku", "name", "quantity", "location", "state" })
public class OrderLineResponseDTO {
    private Long productId;
    private String sku;
    private String name;
    private int quantity;
    private String location;
    private String state;
}
