package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;
import pe.fullstack.pedidos.core.copedidos.model.ProductosRequest;

import java.util.List;
import java.util.Optional;

public interface ProductosService {

    public List<ProductosEntity> findAllProductoss();

    public Optional<ProductosEntity> findProductosById(Long id);

    public ProductosEntity saveProductos(ProductosRequest productosRequest);

    public ProductosEntity updateProductos(ProductosRequest productosRequest, Long id);

    public void deleteProductosById(Long id);
}
