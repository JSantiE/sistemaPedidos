package pe.fullstack.pedidos.core.copedidos.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientesRequest {
	
	private Long clienteId;

    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String direccion;
    
    @NotBlank
    private String detarmento;
    
    @NotBlank
    private String provincia;
    
    
    @NotBlank
    private String distrito;
    
    @NotBlank
    private String celular;
    
    @NotBlank
    private String correo;
    
    @NotBlank
    private String documento;
}
