package com.devemersonc.backend_sys_picking.mapper;

import com.devemersonc.backend_sys_picking.DTO.productDTO.ProductResponseDTO;
import com.devemersonc.backend_sys_picking.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "id")
    List<ProductResponseDTO> toDTOList(List<Product> products);
    ProductResponseDTO toDTO(Product product);
}
