package com.devemersonc.backend_sys_picking.service.product;

import com.devemersonc.backend_sys_picking.DTO.productDTO.CreateUpdateProductDTO;
import com.devemersonc.backend_sys_picking.DTO.productDTO.ProductResponseDTO;
import com.devemersonc.backend_sys_picking.exception.ResourceNotFoundException;
import com.devemersonc.backend_sys_picking.mapper.ProductMapper;
import com.devemersonc.backend_sys_picking.model.Product;
import com.devemersonc.backend_sys_picking.repository.ProductRepository;
import com.devemersonc.backend_sys_picking.service.authService.SecurityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final SecurityService securityService;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, SecurityService securityService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.securityService = securityService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTOList(products);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public ProductResponseDTO getProduct(Long product_id) {
        Product product = findProductById(product_id);
        return productMapper.toDTO(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void createProduct(CreateUpdateProductDTO createProductDTO) {
        Product existingProduct = productRepository.findBySku(createProductDTO.getSku());
        if(existingProduct != null) {
            throw new ResourceNotFoundException("Sku ya asociado a un producto");
        }else {
            Product product = new Product();
            product.setSku(createProductDTO.getSku());
            product.setName(createProductDTO.getName());
            product.setAmount(createProductDTO.getAmount());
            product.setLocation(createProductDTO.getLocation());
            product.setUser(securityService.getAuthenticatedUser());
            productRepository.save(product);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateProduct(Long product_id, CreateUpdateProductDTO createProductDTO) {
        Product product = findProductById(product_id);
        product.setSku(createProductDTO.getSku());
        product.setName(createProductDTO.getName());
        product.setAmount(createProductDTO.getAmount());
        product.setLocation(createProductDTO.getLocation());
        productRepository.save(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteProduct(Long product_id) {
        Product product = findProductById(product_id);
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product findProductById(Long product_id) {
        Product product = productRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado."));
        return product;
    }

    @Override
    public ProductResponseDTO searchProduct(String data) {
        Product product = productRepository.findBySku(data);

        if(product == null) {
            product = productRepository.findByName(data);
        }
        if(product == null) {
            product = productRepository.findByLocation(data);
        }
        if(product == null) {
            throw new ResourceNotFoundException("Producto no encontrado.");
        }

        return productMapper.toDTO(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void discountStock(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado."));
        product.setAmount(product.getAmount() - quantity);
        productRepository.save(product);
    }
}