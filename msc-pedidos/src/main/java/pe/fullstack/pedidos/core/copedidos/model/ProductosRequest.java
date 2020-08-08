package pe.fullstack.pedidos.core.copedidos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.fullstack.pedidos.core.copedidos.domain.CategoriasEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosRequest {
	
	private Long productoId;

    private CategoriasEntity categoria;
       
    private Double precio;
    
    private String nombre;
    
    private String descripcion;
    
    private int stock;
}
