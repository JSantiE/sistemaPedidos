package pe.fullstack.pedidos.core.copedidos.domain;

import java.util.Date;

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
@Table(name="historialpedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HistorialpedidosEntity {

    @Id
    @SequenceGenerator(name = "historialpedidos_id_generator", sequenceName = "historialpedidos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "historialpedidos_id_generator")
    private Long historialPedidoId;

    @JoinColumn(name = "pedidoId", referencedColumnName = "pedidoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PedidosEntity pedido;
    
    private Date fecha;
    
    private String estado;
}
