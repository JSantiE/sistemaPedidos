package pe.fullstack.pedidos.core.copedidos.service.impl;

import pe.fullstack.pedidos.core.copedidos.domain.EstadosEntity;
import pe.fullstack.pedidos.core.copedidos.repository.EstadosRepository;
import pe.fullstack.pedidos.core.copedidos.model.EstadosRequest;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.EstadosDTOToEstadosEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.fullstack.pedidos.core.copedidos.service.EstadosService;
import pe.fullstack.pedidos.core.copedidos.exception.ModelNotFoundException;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EstadosServiceImpl implements EstadosService {

    private final EstadosRepository estadosRepository;
    private EstadosDTOToEstadosEntityMapper estadosDTOToEstadosEntityMapper = new EstadosDTOToEstadosEntityMapper();


    @Autowired
    public EstadosServiceImpl(EstadosRepository estadosRepository) {
        this.estadosRepository = estadosRepository;
    }

    public List<EstadosEntity> findAllEstadoss() {

        List<EstadosEntity> listEstados = estadosRepository.findAll();

        log.info("GET ALL Estados MESSAGE TEST" );
        return listEstados;
    }

    public Optional<EstadosEntity> findEstadosById(Long id) {

        Optional<EstadosEntity> optionalEstados = estadosRepository.findById(id);

        log.info("GET Estados/ MESSAGE TEST" );
        
        return optionalEstados;
    }

    public EstadosEntity saveEstados(EstadosRequest estadosRequest) {

        EstadosEntity estadosEntity = estadosRepository.save(estadosDTOToEstadosEntityMapper.estadosDTOToEstadosEntityMapper(estadosRequest));

        log.info("POST Estados MESSAGE TEST" );
        
        return estadosEntity;
    }

    public EstadosEntity updateEstados(EstadosRequest estadosRequest, Long id) {



        return estadosRepository.findById(id).map(estadosRequestObje -> {
            estadosRequest.setEstadoId(id);
            EstadosEntity estados = estadosRepository.save(estadosDTOToEstadosEntityMapper.estadosDTOToEstadosEntityMapper(estadosRequest));
            log.info("UPDATE Estados MESSAGE TEST" );
            
        return estados;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deleteEstadosById(Long id) {

        estadosRepository.findById(id).ifPresent(delete -> estadosRepository.deleteById(id));

        log.info("DELETE Estados/ MESSAGE TEST" );
        
    }
}