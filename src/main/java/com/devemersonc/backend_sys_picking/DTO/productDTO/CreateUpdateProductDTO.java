package com.devemersonc.backend_sys_picking.DTO.productDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUpdateProductDTO {
    @NotBlank(message = "El código de producto es obligatorio.")
    private String sku;
    @NotBlank(message = "El nombre de producto es obligatorio.")
    private String name;
    private int amount;
    @NotBlank(message = "La ubicación es obligatoria.")
    private String location;
}
