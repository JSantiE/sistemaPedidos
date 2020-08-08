package pe.fullstack.pedidos.core.copedidos.service.impl;

import pe.fullstack.pedidos.core.copedidos.domain.CategoriasEntity;
import pe.fullstack.pedidos.core.copedidos.repository.CategoriasRepository;
import pe.fullstack.pedidos.core.copedidos.model.CategoriasRequest;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.CategoriasDTOToCategoriasEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.fullstack.pedidos.core.copedidos.service.CategoriasService;
import pe.fullstack.pedidos.core.copedidos.exception.ModelNotFoundException;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class CategoriasServiceImpl implements CategoriasService {

    private final CategoriasRepository categoriasRepository;
    private CategoriasDTOToCategoriasEntityMapper categoriasDTOToCategoriasEntityMapper = new CategoriasDTOToCategoriasEntityMapper();


    @Autowired
    public CategoriasServiceImpl(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<CategoriasEntity> findAllCategoriass() {

        List<CategoriasEntity> listCategorias = categoriasRepository.findAll();

        log.info("GET ALL Categorias MESSAGE TEST" );
        return listCategorias;
    }

    public Optional<CategoriasEntity> findCategoriasById(Long id) {

        Optional<CategoriasEntity> optionalCategorias = categoriasRepository.findById(id);

        log.info("GET Categorias/ MESSAGE TEST" );
        
        return optionalCategorias;
    }

    public CategoriasEntity saveCategorias(CategoriasRequest categoriasRequest) {

        CategoriasEntity categoriasEntity = categoriasRepository.save(categoriasDTOToCategoriasEntityMapper.categoriasDTOToCategoriasEntityMapper(categoriasRequest));

        log.info("POST Categorias MESSAGE TEST" );
        
        return categoriasEntity;
    }

    public CategoriasEntity updateCategorias(CategoriasRequest categoriasRequest, Long id) {



        return categoriasRepository.findById(id).map(categoriasRequestObje -> {
            categoriasRequest.setCategoriaId(id);
            CategoriasEntity categorias = categoriasRepository.save(categoriasDTOToCategoriasEntityMapper.categoriasDTOToCategoriasEntityMapper(categoriasRequest));
            log.info("UPDATE Categorias MESSAGE TEST" );
            
        return categorias;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deleteCategoriasById(Long id) {

        categoriasRepository.findById(id).ifPresent(delete -> categoriasRepository.deleteById(id));

        log.info("DELETE Categorias/ MESSAGE TEST" );
        
    }
}