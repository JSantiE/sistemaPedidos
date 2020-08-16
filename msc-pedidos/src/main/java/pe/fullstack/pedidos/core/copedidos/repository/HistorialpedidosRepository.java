package pe.fullstack.pedidos.core.copedidos.repository;

import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialpedidosRepository extends JpaRepository<HistorialpedidosEntity, Long> {
	
	List<HistorialpedidosEntity> findByPedido(PedidosEntity pedido);
}
