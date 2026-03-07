package com.devemersonc.backend_sys_picking.DTO.orderDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductQuantityDTO {
    private Long productId;
    private int quantity;
}
