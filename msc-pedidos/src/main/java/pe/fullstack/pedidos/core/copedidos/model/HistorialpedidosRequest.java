package pe.fullstack.pedidos.core.copedidos.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.fullstack.pedidos.core.copedidos.domain.PedidosEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialpedidosRequest {
	
	private Long historialPedidoId;

	@NotBlank
    private PedidosEntity pedido;
    
	@NotBlank
    private String estado;
}
