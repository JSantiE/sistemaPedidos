package pe.fullstack.pedidos.core.copedidos.service;

import pe.fullstack.pedidos.core.copedidos.domain.EstadosEntity;
import pe.fullstack.pedidos.core.copedidos.model.EstadosRequest;

import java.util.List;
import java.util.Optional;

public interface EstadosService {

    public List<EstadosEntity> findAllEstadoss();

    public Optional<EstadosEntity> findEstadosById(Long id);

    public EstadosEntity saveEstados(EstadosRequest estadosRequest);

    public EstadosEntity updateEstados(EstadosRequest estadosRequest, Long id);

    public void deleteEstadosById(Long id);
}
