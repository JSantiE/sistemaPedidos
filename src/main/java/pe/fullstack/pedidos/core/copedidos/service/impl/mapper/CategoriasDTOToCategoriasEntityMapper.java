package pe.fullstack.pedidos.core.copedidos.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.fullstack.pedidos.core.copedidos.domain.CategoriasEntity;
import pe.fullstack.pedidos.core.copedidos.model.CategoriasRequest;

public class CategoriasDTOToCategoriasEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public CategoriasEntity categoriasDTOToCategoriasEntityMapper(CategoriasRequest categoriasRequest) {
        return modelMapper.map(categoriasRequest, CategoriasEntity.class);
    }
}