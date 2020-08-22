package pe.fullstack.pedidos.core.copedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidosEntity, Long> {
	
	List<DetallePedidosEntity> findByPedido(PedidosEntity pedido);
}
