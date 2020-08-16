package pe.fullstack.pedidos.core.copedidos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="detalle_pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetallePedidosEntity {

    @Id
    @SequenceGenerator(name = "detallePedidos_id_generator", sequenceName = "detallePedidos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "detallePedidos_id_generator")
    private Long detallePedidoId;
    
    @JsonIgnore
    @JoinColumn(name = "pedidoId", referencedColumnName = "pedidoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PedidosEntity pedido;
    
    @JoinColumn(name = "productoId", referencedColumnName = "productoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosEntity producto;
    
    @Column(nullable = false)
    private Long cantidad;
}
