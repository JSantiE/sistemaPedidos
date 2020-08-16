package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.PedidosRequest;

public class PedidosDTOToPedidosEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public PedidosEntity pedidosDTOToPedidosEntityMapper(PedidosRequest pedidosRequest) {
        return modelMapper.map(pedidosRequest, PedidosEntity.class);
    }
}