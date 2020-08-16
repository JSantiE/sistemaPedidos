package pe.fullstack.pedidos.core.copedidos.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.fullstack.pedidos.core.copedidos.domain.EstadosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;
import pe.fullstack.pedidos.core.copedidos.repository.HistorialpedidosRepository;
import pe.fullstack.pedidos.core.copedidos.repository.PedidosRepository;
import pe.fullstack.pedidos.core.copedidos.service.HistorialpedidosService;

@Slf4j
@Service
@Transactional
public class HistorialpedidosServiceImpl implements HistorialpedidosService {

    private final HistorialpedidosRepository historialpedidosRepository;
    private final PedidosRepository pedidosRepository;
    @Autowired
    public HistorialpedidosServiceImpl(HistorialpedidosRepository historialpedidosRepository,
    		PedidosRepository pedidosRepository) {
        this.historialpedidosRepository = historialpedidosRepository;
        this.pedidosRepository = pedidosRepository;
    }

    public List<HistorialpedidosEntity> findAllHistorialpedidoss() {

        List<HistorialpedidosEntity> listHistorialpedidos = historialpedidosRepository.findAll();

        log.info("GET ALL Historialpedidos MESSAGE TEST" );
        return listHistorialpedidos;
    }


    public HistorialpedidosEntity saveHistorialpedidos(HistorialpedidosRequest historialpedidosRequest) {

        HistorialpedidosEntity historialpedidosEntity = new HistorialpedidosEntity();

        if(pedidosRepository.findById(historialpedidosRequest.getPedidoId()).isPresent()) {
        	PedidosEntity pedidoEntity = pedidosRepository.findById(historialpedidosRequest.getPedidoId()).get(); 
        	EstadosEntity estado = null;
			try {
				estado = pedidoEntity.getEstado().clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	estado.setEstadoId(estado.getEstadoId() + 1L);
        	pedidoEntity.setEstado(estado);
        	pedidosRepository.save(pedidoEntity);
        	historialpedidosEntity.setFecha(new Date());
        	historialpedidosEntity.setPedido(pedidoEntity);
        	historialpedidosEntity.setEstado(estado);
        }else {
        	 return historialpedidosEntity;
        }
       
        
 
        historialpedidosRepository.save(historialpedidosEntity);
        
        
        log.info("POST Historialpedidos MESSAGE TEST" );
        
        return historialpedidosEntity;
    }


}