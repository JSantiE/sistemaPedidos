package pe.fullstack.pedidos.core.copedidos.service;

import java.util.List;
import java.util.Optional;

import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.PedidosRequest;

public interface PedidosService {

    public List<PedidosEntity> findAllPedidoss();

    public Optional<PedidosEntity> findPedidosById(Long id);

    public PedidosEntity savePedidos(PedidosRequest pedidosRequest);

    public PedidosEntity updatePedidos(PedidosRequest pedidosRequest, Long id);

    public void deletePedidosById(Long id);

	public List<HistorialpedidosEntity> searchHistorialPedidosById(Long id);

	public List<DetallePedidosEntity> searchDetallePedidosById(Long id);

	public List<PedidosEntity> findAllPedidos(Long id);
}
