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
@Table(name = "pedidos")
public class pedidosBean {
    @Id
    @Column(name = "id_pedidos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedidos;

    @Column(name = "fecha_pedido")
    private String fecha_pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuariosBean")
    private usuariosBean usuariosBean;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidosBean", cascade = CascadeType.ALL)
    private Set<detallesBean> detallesBeanSet = new HashSet<>();

    @ManyToMany(mappedBy = "pedidosBeanSet")
    Set<productosBean> productosBeanSet;

}
