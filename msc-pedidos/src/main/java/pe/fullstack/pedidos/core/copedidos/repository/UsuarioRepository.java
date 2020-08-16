package pe.fullstack.pedidos.core.copedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.fullstack.pedidos.core.copedidos.domain.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	public List<UsuarioEntity> findByUsernameAndPassword(String username, String password);
}
