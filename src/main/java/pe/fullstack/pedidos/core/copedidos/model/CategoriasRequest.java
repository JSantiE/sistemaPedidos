package pe.fullstack.pedidos.core.copedidos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriasRequest {
	
	private Long categoriaId;

    private String nombre;
}
