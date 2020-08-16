package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;

import pe.fullstack.pedidos.core.copedidos.domain.UsuarioEntity;
import pe.fullstack.pedidos.core.copedidos.model.UsuarioRequest;

public class UsuarioDTOToUsuarioEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public UsuarioEntity usuarioDTOTousuarioEntityMapper(UsuarioRequest UsuarioRequest) {
        return modelMapper.map(UsuarioRequest, UsuarioEntity.class);
    }
}