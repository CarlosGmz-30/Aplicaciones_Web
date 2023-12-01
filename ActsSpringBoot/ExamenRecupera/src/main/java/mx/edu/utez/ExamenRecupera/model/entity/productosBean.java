package mx.edu.utez.ExamenRecupera.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "productos")
public class productosBean {
    @Id
    @Column(name = "id_productos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_productos;

    @Column(name = "nombre_producto")
    private String nombre_producto;

    @Column(name = "precio")
    private Double precio;

    @ManyToMany
    @JoinTable(name = "productosPedidos",
            joinColumns = @JoinColumn(name = "id_productos"),
            inverseJoinColumns = @JoinColumn(name = "id_pedidos"))
    Set<pedidosBean> pedidosBeanSet = new HashSet<>();

}
