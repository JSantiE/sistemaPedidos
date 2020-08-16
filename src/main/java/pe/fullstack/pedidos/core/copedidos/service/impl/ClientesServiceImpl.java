package pe.fullstack.pedidos.core.copedidos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.fullstack.pedidos.core.copedidos.domain.ClientesEntity;
import pe.fullstack.pedidos.core.copedidos.model.ClientesRequest;
import pe.fullstack.pedidos.core.copedidos.repository.ClientesRepository;
import pe.fullstack.pedidos.core.copedidos.service.ClientesService;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.ClientesDTOToClientesEntityMapper;

@Slf4j
@Service
@Transactional
public class ClientesServiceImpl implements ClientesService {

    private final ClientesRepository clientesRepository;
    private ClientesDTOToClientesEntityMapper clientesDTOToClientesEntityMapper = new ClientesDTOToClientesEntityMapper();


    @Autowired
    public ClientesServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public List<ClientesEntity> findAllClientess() {

        List<ClientesEntity> listClientes = clientesRepository.findAll();

        log.info("GET ALL Clientes MESSAGE TEST" );
        return listClientes;
    }

    public Optional<ClientesEntity> findClientesById(Long id) {

        Optional<ClientesEntity> optionalClientes = clientesRepository.findById(id);

        log.info("GET Clientes/ MESSAGE TEST" );
        
        return optionalClientes;
    }

    public ClientesEntity saveClientes(ClientesRequest clientesRequest) {

        ClientesEntity clientesEntity = clientesRepository.save(clientesDTOToClientesEntityMapper.clientesDTOToClientesEntityMapper(clientesRequest));

        log.info("POST Clientes MESSAGE TEST" );
        
        return clientesEntity;
    }

    public ClientesEntity updateClientes(ClientesRequest clientesRequest, Long id) {

    	return null;
    }

    public void deleteClientesById(Long id) {

        clientesRepository.findById(id).ifPresent(delete -> clientesRepository.deleteById(id));

        log.info("DELETE Clientes/ MESSAGE TEST" );
        
    }
}