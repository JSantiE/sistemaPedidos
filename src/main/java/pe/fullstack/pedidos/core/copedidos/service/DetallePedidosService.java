package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.model.DetallePedidosRequest;

import java.util.List;
import java.util.Optional;

public interface DetallePedidosService {

    public List<DetallePedidosEntity> findAllDetallePedidoss();

    public Optional<DetallePedidosEntity> findDetallePedidosById(Long id);

    public DetallePedidosEntity saveDetallePedidos(DetallePedidosRequest detallePedidosRequest);

    public DetallePedidosEntity updateDetallePedidos(DetallePedidosRequest detallePedidosRequest, Long id);

    public void deleteDetallePedidosById(Long id);
}
