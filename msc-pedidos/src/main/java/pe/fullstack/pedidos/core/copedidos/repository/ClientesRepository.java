package pe.fullstack.pedidos.core.copedidos.repository;

import pe.fullstack.pedidos.core.copedidos.domain.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {
}
