package pe.fullstack.pedidos.core.copedidos.repository;

import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {
}
