package mx.edu.utez.ExamenRecupera.model.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
