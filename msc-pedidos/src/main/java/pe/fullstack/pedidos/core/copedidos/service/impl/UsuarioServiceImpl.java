package pe.fullstack.pedidos.core.copedidos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;
import pe.fullstack.pedidos.core.copedidos.domain.UsuarioEntity;
import pe.fullstack.pedidos.core.copedidos.exception.ModelNotFoundException;
import pe.fullstack.pedidos.core.copedidos.model.UsuarioRequest;
import pe.fullstack.pedidos.core.copedidos.repository.UsuarioRepository;
import pe.fullstack.pedidos.core.copedidos.service.UsuarioService;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.UsuarioDTOToUsuarioEntityMapper;

@Slf4j
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository UsuarioRepository;
    private UsuarioDTOToUsuarioEntityMapper UsuarioDTOToUsuarioEntityMapper = new UsuarioDTOToUsuarioEntityMapper();


    @Autowired
    public UsuarioServiceImpl(UsuarioRepository UsuarioRepository) {
        log.info("");
    	this.UsuarioRepository = UsuarioRepository;
     
    }

    public List<UsuarioEntity> findAllusuarios() {

        List<UsuarioEntity> listusuario = UsuarioRepository.findAll();

        return listusuario;
    }

    public Optional<UsuarioEntity> findusuarioById(Long id) {

        Optional<UsuarioEntity> optionalusuario = UsuarioRepository.findById(id);


        return optionalusuario;
    }

    public UsuarioEntity saveusuario(UsuarioRequest UsuarioRequest) {

        UsuarioEntity UsuarioEntity = UsuarioRepository.save(UsuarioDTOToUsuarioEntityMapper.usuarioDTOTousuarioEntityMapper(UsuarioRequest));

        return UsuarioEntity;
    }

    public UsuarioEntity updateusuario(UsuarioRequest UsuarioRequest, Long id) {

        return UsuarioRepository.findById(id).map(usuarioRequestObje -> {
            UsuarioRequest.setId(id);
            UsuarioEntity usuario = UsuarioRepository.save(UsuarioDTOToUsuarioEntityMapper.usuarioDTOTousuarioEntityMapper(UsuarioRequest));

        return usuario;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deleteusuarioById(Long id) {

        UsuarioRepository.findById(id).ifPresent(delete -> UsuarioRepository.deleteById(id));

    }

	@Override
	public UsuarioEntity login(String username, String password) {
		List<UsuarioEntity> listusuario =  UsuarioRepository.findByUsernameAndPassword(username, password);
		if (listusuario.isEmpty()) {
			throw new ModelNotFoundException("USUARIO O CLAVE INCORRECTOS");
		}
		return listusuario.get(0);
	}
}