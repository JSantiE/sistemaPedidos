package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.ClientesEntity;
import pe.fullstack.pedidos.core.copedidos.model.ClientesRequest;

import java.util.List;
import java.util.Optional;

public interface ClientesService {

    public List<ClientesEntity> findAllClientess();

    public Optional<ClientesEntity> findClientesById(Long id);

    public ClientesEntity saveClientes(ClientesRequest clientesRequest);

    public ClientesEntity updateClientes(ClientesRequest clientesRequest, Long id);

    public void deleteClientesById(Long id);
}
