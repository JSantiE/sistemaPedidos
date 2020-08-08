package pe.fullstack.pedidos.core.copedidos.service.impl;

import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.repository.HistorialpedidosRepository;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.HistorialpedidosDTOToHistorialpedidosEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.fullstack.pedidos.core.copedidos.service.HistorialpedidosService;
import pe.fullstack.pedidos.core.copedidos.exception.ModelNotFoundException;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class HistorialpedidosServiceImpl implements HistorialpedidosService {

    private final HistorialpedidosRepository historialpedidosRepository;
    private HistorialpedidosDTOToHistorialpedidosEntityMapper historialpedidosDTOToHistorialpedidosEntityMapper = new HistorialpedidosDTOToHistorialpedidosEntityMapper();


    @Autowired
    public HistorialpedidosServiceImpl(HistorialpedidosRepository historialpedidosRepository) {
        this.historialpedidosRepository = historialpedidosRepository;
    }

    public List<HistorialpedidosEntity> findAllHistorialpedidoss() {

        List<HistorialpedidosEntity> listHistorialpedidos = historialpedidosRepository.findAll();

        log.info("GET ALL Historialpedidos MESSAGE TEST" );
        return listHistorialpedidos;
    }

    public Optional<HistorialpedidosEntity> findHistorialpedidosById(Long id) {

        Optional<HistorialpedidosEntity> optionalHistorialpedidos = historialpedidosRepository.findById(id);

        log.info("GET Historialpedidos/ MESSAGE TEST" );
        
        return optionalHistorialpedidos;
    }

    public HistorialpedidosEntity saveHistorialpedidos(HistorialpedidosRequest historialpedidosRequest) {

        HistorialpedidosEntity historialpedidosEntity = historialpedidosRepository.save(historialpedidosDTOToHistorialpedidosEntityMapper.historialpedidosDTOToHistorialpedidosEntityMapper(historialpedidosRequest));

        log.info("POST Historialpedidos MESSAGE TEST" );
        
        return historialpedidosEntity;
    }

    public HistorialpedidosEntity updateHistorialpedidos(HistorialpedidosRequest historialpedidosRequest, Long id) {



        return historialpedidosRepository.findById(id).map(historialpedidosRequestObje -> {
            historialpedidosRequest.setHistorialPedidoId(id);
            HistorialpedidosEntity historialpedidos = historialpedidosRepository.save(historialpedidosDTOToHistorialpedidosEntityMapper.historialpedidosDTOToHistorialpedidosEntityMapper(historialpedidosRequest));
            log.info("UPDATE Historialpedidos MESSAGE TEST" );
            
        return historialpedidos;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deleteHistorialpedidosById(Long id) {

        historialpedidosRepository.findById(id).ifPresent(delete -> historialpedidosRepository.deleteById(id));

        log.info("DELETE Historialpedidos/ MESSAGE TEST" );
        
    }
}