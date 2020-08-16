package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.DetallePedidosRequest;

public class DetallePedidosDTOToDetallePedidosEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public DetallePedidosEntity detallePedidosDTOToDetallePedidosEntityMapper(DetallePedidosRequest detallePedidosRequest) {
        return modelMapper.map(detallePedidosRequest, DetallePedidosEntity.class);
    }
}