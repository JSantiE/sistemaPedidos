package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;
import pe.fullstack.pedidos.core.copedidos.model.ProductosRequest;

public class ProductosDTOToProductosEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public ProductosEntity productosDTOToProductosEntityMapper(ProductosRequest productosRequest) {
        return modelMapper.map(productosRequest, ProductosEntity.class);
    }
}