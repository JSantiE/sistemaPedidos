package pe.fullstack.pedidos.core.copedidos.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidosRequest {
	    
    private ClientesRequest cliente;
    
    private List<DetallePedidosRequest> detallePedidos;
    
    private Date fechaEntrega;
}
