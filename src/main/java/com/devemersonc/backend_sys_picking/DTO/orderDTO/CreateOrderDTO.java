package com.devemersonc.backend_sys_picking.DTO.orderDTO;

import com.devemersonc.backend_sys_picking.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreateOrderDTO {
    private String numOrder;
    private String state;
    private List<ProductQuantityDTO> products;
}
