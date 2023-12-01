package mx.edu.utez.ExamenRecupera.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "detallesPedido")
public class detallesPedidoBean {
    @Id
    @Column(name = "id_detalles_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalles_pedido;

    @Column(name = "cantidad")
    private String cantidad;
}
