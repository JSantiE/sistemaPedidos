package pe.fullstack.pedidos.core.copedidos.service;

import java.util.List;

import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;

public interface HistorialpedidosService {

    public List<HistorialpedidosEntity> findAllHistorialpedidoss();
    
    public HistorialpedidosEntity saveHistorialpedidos(HistorialpedidosRequest historialpedidosRequest);


}