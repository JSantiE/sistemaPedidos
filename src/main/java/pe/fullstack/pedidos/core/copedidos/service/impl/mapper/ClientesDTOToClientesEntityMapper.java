package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.ClientesEntity;
import pe.fullstack.pedidos.core.copedidos.model.ClientesRequest;

public class ClientesDTOToClientesEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public ClientesEntity clientesDTOToClientesEntityMapper(ClientesRequest clientesRequest) {
        return modelMapper.map(clientesRequest, ClientesEntity.class);
    }
}