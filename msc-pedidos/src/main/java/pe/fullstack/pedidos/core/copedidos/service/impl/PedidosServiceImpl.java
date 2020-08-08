package pe.fullstack.pedidos.core.copedidos.service.impl;

import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.repository.PedidosRepository;
import pe.fullstack.pedidos.core.copedidos.model.PedidosRequest;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.PedidosDTOToPedidosEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.fullstack.pedidos.core.copedidos.service.PedidosService;
import pe.fullstack.pedidos.core.copedidos.exception.ModelNotFoundException;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PedidosServiceImpl implements PedidosService {

    private final PedidosRepository pedidosRepository;
    private PedidosDTOToPedidosEntityMapper pedidosDTOToPedidosEntityMapper = new PedidosDTOToPedidosEntityMapper();


    @Autowired
    public PedidosServiceImpl(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public List<PedidosEntity> findAllPedidoss() {

        List<PedidosEntity> listPedidos = pedidosRepository.findAll();

        log.info("GET ALL Pedidos MESSAGE TEST" );
        return listPedidos;
    }

    public Optional<PedidosEntity> findPedidosById(Long id) {

        Optional<PedidosEntity> optionalPedidos = pedidosRepository.findById(id);

        log.info("GET Pedidos/ MESSAGE TEST" );
        
        return optionalPedidos;
    }

    public PedidosEntity savePedidos(PedidosRequest pedidosRequest) {

        PedidosEntity pedidosEntity = pedidosRepository.save(pedidosDTOToPedidosEntityMapper.pedidosDTOToPedidosEntityMapper(pedidosRequest));

        log.info("POST Pedidos MESSAGE TEST" );
        
        return pedidosEntity;
    }

    public PedidosEntity updatePedidos(PedidosRequest pedidosRequest, Long id) {



        return pedidosRepository.findById(id).map(pedidosRequestObje -> {
            pedidosRequest.setPedidoId(id);
            PedidosEntity pedidos = pedidosRepository.save(pedidosDTOToPedidosEntityMapper.pedidosDTOToPedidosEntityMapper(pedidosRequest));
            log.info("UPDATE Pedidos MESSAGE TEST" );
            
        return pedidos;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deletePedidosById(Long id) {

        pedidosRepository.findById(id).ifPresent(delete -> pedidosRepository.deleteById(id));

        log.info("DELETE Pedidos/ MESSAGE TEST" );
        
    }
}