package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.PedidosRequest;

import java.util.List;
import java.util.Optional;

public interface PedidosService {

    public List<PedidosEntity> findAllPedidoss();

    public Optional<PedidosEntity> findPedidosById(Long id);

    public PedidosEntity savePedidos(PedidosRequest pedidosRequest);

    public PedidosEntity updatePedidos(PedidosRequest pedidosRequest, Long id);

    public void deletePedidosById(Long id);
}