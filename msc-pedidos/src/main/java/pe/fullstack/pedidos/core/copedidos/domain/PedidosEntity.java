package pe.fullstack.pedidos.core.copedidos.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidosEntity {

    @Id
    @SequenceGenerator(name = "pedidos_id_generator", sequenceName = "pedidos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pedidos_id_generator")
    private Long pedidoId ;
    
    @JoinColumn(name = "clienteId", referencedColumnName = "clienteId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientesEntity cliente;
    
    
    @JoinColumn(name = "estadoId", referencedColumnName = "estadoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadosEntity estado;
}
