package pe.fullstack.pedidos.core.copedidos.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.fullstack.pedidos.core.copedidos.constant.Constant;
import pe.fullstack.pedidos.core.copedidos.domain.ClientesEntity;
import pe.fullstack.pedidos.core.copedidos.domain.DetallePedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.EstadosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.HistorialpedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;
import pe.fullstack.pedidos.core.copedidos.model.DetallePedidosRequest;
import pe.fullstack.pedidos.core.copedidos.model.PedidosRequest;
import pe.fullstack.pedidos.core.copedidos.repository.ClientesRepository;
import pe.fullstack.pedidos.core.copedidos.repository.DetallePedidosRepository;
import pe.fullstack.pedidos.core.copedidos.repository.HistorialpedidosRepository;
import pe.fullstack.pedidos.core.copedidos.repository.PedidosRepository;
import pe.fullstack.pedidos.core.copedidos.repository.ProductosRepository;
import pe.fullstack.pedidos.core.copedidos.service.PedidosService;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.ClientesDTOToClientesEntityMapper;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.DetallePedidosDTOToDetallePedidosEntityMapper;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.PedidosDTOToPedidosEntityMapper;
import pe.fullstack.pedidos.core.copedidos.service.impl.mapper.ProductosDTOToProductosEntityMapper;

@Slf4j
@Service
@Transactional
public class PedidosServiceImpl implements PedidosService {

    private final PedidosRepository pedidosRepository;
    private final ClientesRepository clientesRepository;
    private final DetallePedidosRepository detallePedidosRepository;
    private final HistorialpedidosRepository historialpedidosRepository;
    private final ProductosRepository productosRepository;
    
    private ProductosDTOToProductosEntityMapper productosDTOToProductosEntityMapper = new ProductosDTOToProductosEntityMapper();
    private ClientesDTOToClientesEntityMapper clientesDTOToClientesEntityMapper = new ClientesDTOToClientesEntityMapper();
    private PedidosDTOToPedidosEntityMapper pedidosDTOToPedidosEntityMapper = new PedidosDTOToPedidosEntityMapper();
    private DetallePedidosDTOToDetallePedidosEntityMapper detallePedidosDTOToDetallePedidosEntityMapper = new DetallePedidosDTOToDetallePedidosEntityMapper();
    
    @Autowired
    public PedidosServiceImpl(PedidosRepository pedidosRepository,
    		ClientesRepository clientesRepository,
    		DetallePedidosRepository detallePedidosRepository,
    		HistorialpedidosRepository historialpedidosRepository,
    		ProductosRepository productosRepository) {
        this.pedidosRepository = pedidosRepository;
        this.clientesRepository = clientesRepository;
        this.detallePedidosRepository = detallePedidosRepository;
        this.historialpedidosRepository = historialpedidosRepository;
        this.productosRepository = productosRepository;
    }

    public List<PedidosEntity> findAllPedidoss() {

        List<PedidosEntity> listPedidos = pedidosRepository.findAll();

        log.info("GET ALL Pedidos MESSAGE TEST" );
        return listPedidos;
    }

    public Optional<PedidosEntity> findPedidosById(Long id) {

        Optional<PedidosEntity> optionalPedidos = pedidosRepository.findById(id);

        log.info("GET Pedidos/ MESSAGE TEST" );
        
        return optionalPedidos;
    }

    public PedidosEntity savePedidos(PedidosRequest pedidosRequest) {
    	
    	PedidosEntity pedidosEntity  =  pedidosDTOToPedidosEntityMapper.pedidosDTOToPedidosEntityMapper(pedidosRequest);
    	
    	ClientesEntity clienteEntity = clientesDTOToClientesEntityMapper.clientesDTOToClientesEntityMapper(pedidosRequest.getCliente());
    	clienteEntity = clientesRepository.save(clienteEntity);
    	pedidosEntity.setCliente(clienteEntity);
    	
    	EstadosEntity estado = new EstadosEntity();
    	estado.setEstadoId(Constant.EST_REG_PEDIDO);
    	pedidosEntity.setEstado(estado);
    	
    	pedidosEntity = pedidosRepository.save(pedidosEntity);
    	
    	HistorialpedidosEntity historialpedidosEntity = new HistorialpedidosEntity();
    	historialpedidosEntity.setEstado(estado);
    	historialpedidosEntity.setFecha(new Date());
    	historialpedidosEntity.setPedido(pedidosEntity);
    	historialpedidosRepository.save(historialpedidosEntity);
    	
    	
    	for (DetallePedidosRequest detPedidoRequest : pedidosRequest.getDetallePedidos()) {
    		DetallePedidosEntity detPedidoEntity = detallePedidosDTOToDetallePedidosEntityMapper.detallePedidosDTOToDetallePedidosEntityMapper(detPedidoRequest);
    		detPedidoEntity.setPedido(pedidosEntity);
    		detallePedidosRepository.save(detPedidoEntity);
    		
    		
    		Optional<ProductosEntity> producto =  productosRepository.findById(detPedidoEntity.getProducto().getProductoId());
    		if (producto.isPresent()) {
    			try {
					ProductosEntity product = producto.get().clone();
					product.setStock(product.getStock() - detPedidoRequest.getCantidad().intValue() );
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
    	
        log.info("POST Pedidos MESSAGE TEST" );
        
        return pedidosEntity;
    }

    public PedidosEntity updatePedidos(PedidosRequest pedidosRequest, Long id) {


//
//        return pedidosRepository.findById(id).map(pedidosRequestObje -> {
//            pedidosRequest.setPedidoId(id);
//            PedidosEntity pedidos = pedidosRepository.save(pedidosDTOToPedidosEntityMapper.pedidosDTOToPedidosEntityMapper(pedidosRequest));
//            log.info("UPDATE Pedidos MESSAGE TEST" );
//            
//        return pedidos;
//
//        })
//        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    	return null;
    }

    public void deletePedidosById(Long id) {

        pedidosRepository.findById(id).ifPresent(delete -> pedidosRepository.deleteById(id));

        log.info("DELETE Pedidos/ MESSAGE TEST" );
        
    }

	@Override
	public List<HistorialpedidosEntity> searchHistorialPedidosById(Long id) {

		return historialpedidosRepository.findByPedido(pedidosRepository.findById(id).get());
	}

	@Override
	public List<DetallePedidosEntity> searchDetallePedidosById(Long id) {
		
		Optional<PedidosEntity>  pedidoOptional = this.findPedidosById(id);
		return detallePedidosRepository.findByPedido(pedidoOptional.get());
	}

	@Override
	public List<PedidosEntity> findAllPedidos(Long tipoUsuario) {
		List<PedidosEntity> pedidosFilter = new ArrayList<>();
		List<PedidosEntity> pedidos = pedidosRepository.findAll();
		for (PedidosEntity pedidosEntity : pedidos) {
			if (tipoUsuario == 1) {
				if (pedidosEntity.getEstado().getEstadoId() !=  3 || pedidosEntity.getEstado().getEstadoId() !=  4  ) {
					pedidosFilter.add(pedidosEntity);
				}
			}else {
				if (pedidosEntity.getEstado().getEstadoId() ==  3  || pedidosEntity.getEstado().getEstadoId() ==  4) {
					pedidosFilter.add(pedidosEntity);
				}
			}
		}
		
		return pedidosFilter;
	}
}