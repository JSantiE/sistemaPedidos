package pe.fullstack.pedidos.core.copedidos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.DetallePedidosRequest;
import pe.fullstack.pedidos.core.copedidos.repository.DetallePedidosRepository;
import pe.fullstack.pedidos.core.copedidos.service.DetallePedidosService;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.DetallePedidosDTOToDetallePedidosEntityMapper;

@Slf4j
@Service
@Transactional
public class DetallePedidosServiceImpl implements DetallePedidosService {

    private final DetallePedidosRepository detallePedidosRepository;
    private DetallePedidosDTOToDetallePedidosEntityMapper detallePedidosDTOToDetallePedidosEntityMapper = new DetallePedidosDTOToDetallePedidosEntityMapper();


    @Autowired
    public DetallePedidosServiceImpl(DetallePedidosRepository detallePedidosRepository) {
        this.detallePedidosRepository = detallePedidosRepository;
    }

    public List<DetallePedidosEntity> findAllDetallePedidoss() {

        List<DetallePedidosEntity> listDetallePedidos = detallePedidosRepository.findAll();

        log.info("GET ALL DetallePedidos MESSAGE TEST" );
        return listDetallePedidos;
    }

    public Optional<DetallePedidosEntity> findDetallePedidosById(Long id) {

        Optional<DetallePedidosEntity> optionalDetallePedidos = detallePedidosRepository.findById(id);

        log.info("GET DetallePedidos/ MESSAGE TEST" );
        
        return optionalDetallePedidos;
    }

    public DetallePedidosEntity saveDetallePedidos(DetallePedidosRequest detallePedidosRequest) {

        DetallePedidosEntity detallePedidosEntity = detallePedidosRepository.save(detallePedidosDTOToDetallePedidosEntityMapper.detallePedidosDTOToDetallePedidosEntityMapper(detallePedidosRequest));

        log.info("POST DetallePedidos MESSAGE TEST" );
        
        return detallePedidosEntity;
    }

    public DetallePedidosEntity updateDetallePedidos(DetallePedidosRequest detallePedidosRequest, Long id) {

    	return null;

//        return detallePedidosRepository.findById(id).map(detallePedidosRequestObje -> {
//            detallePedidosRequest.setDetallePedidoId(id);
//            DetallePedidosEntity detallePedidos = detallePedidosRepository.save(detallePedidosDTOToDetallePedidosEntityMapper.detallePedidosDTOToDetallePedidosEntityMapper(detallePedidosRequest));
//            log.info("UPDATE DetallePedidos MESSAGE TEST" );
//            
//        return detallePedidos;
//
//        })
//        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deleteDetallePedidosById(Long id) {

        detallePedidosRepository.findById(id).ifPresent(delete -> detallePedidosRepository.deleteById(id));

        log.info("DELETE DetallePedidos/ MESSAGE TEST" );
        
    }
}