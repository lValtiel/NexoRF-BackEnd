package com.devemersonc.backend_sys_picking.DTO.orderDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDTO {
    private String numOrder;
    private String state;
}
