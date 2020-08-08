package pe.fullstack.pedidos.core.copedidos.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriasEntity {

    @Id
    @SequenceGenerator(name = "categorias_id_generator", sequenceName = "categorias_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "categorias_id_generator")
    private Long categoriaId;

    @Column(nullable = false)
    private String nombre;
    
    @JsonIgnore
    @OneToMany( mappedBy = "categoria", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<ProductosEntity> productoCollection;
}
