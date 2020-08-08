package pe.fullstack.pedidos.core.copedidos.service.impl;

import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;
import pe.fullstack.pedidos.core.copedidos.repository.ProductosRepository;
import pe.fullstack.pedidos.core.copedidos.model.ProductosRequest;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.ProductosDTOToProductosEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.fullstack.pedidos.core.copedidos.service.ProductosService;
import pe.fullstack.pedidos.core.copedidos.exception.ModelNotFoundException;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository productosRepository;
    private ProductosDTOToProductosEntityMapper productosDTOToProductosEntityMapper = new ProductosDTOToProductosEntityMapper();


    @Autowired
    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public List<ProductosEntity> findAllProductoss() {

        List<ProductosEntity> listProductos = productosRepository.findAll();

        log.info("GET ALL Productos MESSAGE TEST" );
        return listProductos;
    }

    public Optional<ProductosEntity> findProductosById(Long id) {

        Optional<ProductosEntity> optionalProductos = productosRepository.findById(id);

        log.info("GET Productos/ MESSAGE TEST" );
        
        return optionalProductos;
    }

    public ProductosEntity saveProductos(ProductosRequest productosRequest) {

        ProductosEntity productosEntity = productosRepository.save(productosDTOToProductosEntityMapper.productosDTOToProductosEntityMapper(productosRequest));

        log.info("POST Productos MESSAGE TEST" );
        
        return productosEntity;
    }

    public ProductosEntity updateProductos(ProductosRequest productosRequest, Long id) {



        return productosRepository.findById(id).map(productosRequestObje -> {
            productosRequest.setProductoId(id);
            ProductosEntity productos = productosRepository.save(productosDTOToProductosEntityMapper.productosDTOToProductosEntityMapper(productosRequest));
            log.info("UPDATE Productos MESSAGE TEST" );
            
        return productos;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deleteProductosById(Long id) {

        productosRepository.findById(id).ifPresent(delete -> productosRepository.deleteById(id));

        log.info("DELETE Productos/ MESSAGE TEST" );
        
    }
}