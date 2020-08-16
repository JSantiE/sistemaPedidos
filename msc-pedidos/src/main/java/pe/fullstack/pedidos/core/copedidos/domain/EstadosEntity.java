package pe.fullstack.pedidos.core.copedidos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="estados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EstadosEntity  implements Cloneable{

    @Id
    @SequenceGenerator(name = "estados_id_generator", sequenceName = "estados_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "estados_id_generator")
    private Long estadoId;

    @Column(nullable = false)
    private String nombre;
    
    
    @Override
    public EstadosEntity clone() throws CloneNotSupportedException {
    
    	EstadosEntity nueva= new EstadosEntity (this.estadoId,this.nombre);
        return nueva;
    }
}
