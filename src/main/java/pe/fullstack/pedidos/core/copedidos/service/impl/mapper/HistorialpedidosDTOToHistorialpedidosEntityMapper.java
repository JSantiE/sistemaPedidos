package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;

public class HistorialpedidosDTOToHistorialpedidosEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public HistorialpedidosEntity historialpedidosDTOToHistorialpedidosEntityMapper(HistorialpedidosRequest historialpedidosRequest) {
        return modelMapper.map(historialpedidosRequest, HistorialpedidosEntity.class);
    }
}