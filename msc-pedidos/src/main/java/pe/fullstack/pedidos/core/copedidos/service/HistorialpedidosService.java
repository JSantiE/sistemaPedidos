package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.HistorialpedidosRequest;

import java.util.List;
import java.util.Optional;

public interface HistorialpedidosService {

    public List<HistorialpedidosEntity> findAllHistorialpedidoss();

    public Optional<HistorialpedidosEntity> findHistorialpedidosById(Long id);

    public HistorialpedidosEntity saveHistorialpedidos(HistorialpedidosRequest historialpedidosRequest);

    public HistorialpedidosEntity updateHistorialpedidos(HistorialpedidosRequest historialpedidosRequest, Long id);

    public void deleteHistorialpedidosById(Long id);
}
