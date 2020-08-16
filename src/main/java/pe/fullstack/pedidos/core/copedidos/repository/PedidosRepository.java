package pe.fullstack.pedidos.core.copedidos.repository;

import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosEntity, Long> {
	
	
}
