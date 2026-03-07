package com.devemersonc.backend_sys_picking.DTO.productDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Long id;
    private String sku;
    private String name;
    private int amount;
    private String location;
}
