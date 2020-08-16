package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.EstadosEntity;
import pe.fullstack.pedidos.core.copedidos.model.EstadosRequest;

public class EstadosDTOToEstadosEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public EstadosEntity estadosDTOToEstadosEntityMapper(EstadosRequest estadosRequest) {
        return modelMapper.map(estadosRequest, EstadosEntity.class);
    }
}