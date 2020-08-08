package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.CategoriasEntity;
import pe.fullstack.pedidos.core.copedidos.model.CategoriasRequest;

import java.util.List;
import java.util.Optional;

public interface CategoriasService {

    public List<CategoriasEntity> findAllCategoriass();

    public Optional<CategoriasEntity> findCategoriasById(Long id);

    public CategoriasEntity saveCategorias(CategoriasRequest categoriasRequest);

    public CategoriasEntity updateCategorias(CategoriasRequest categoriasRequest, Long id);

    public void deleteCategoriasById(Long id);
}
