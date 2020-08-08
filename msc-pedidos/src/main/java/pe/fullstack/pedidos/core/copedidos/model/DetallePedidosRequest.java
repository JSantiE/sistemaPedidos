package pe.fullstack.pedidos.core.copedidos.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;
import pe.fullstack.pedidos.core.copedidos.domain.ProductosEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidosRequest {
	
	 private Long detallePedidoId;

	 @NotBlank
	 private PedidosEntity pedido;
	    
	 @NotBlank
	 private ProductosEntity producto;
	    
	 @NotBlank
	 private Long cantidad;
}
