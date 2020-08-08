package pe.fullstack.pedidos.core.copedidos.repository;

import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidosEntity, Long> {
}
