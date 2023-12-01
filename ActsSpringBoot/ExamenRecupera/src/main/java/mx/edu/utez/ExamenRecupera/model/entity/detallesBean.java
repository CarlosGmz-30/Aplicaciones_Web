package mx.edu.utez.ExamenRecupera.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "detalles")
public class detallesBean {
    @Id
    @Column(name = "id_detalles")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalles_pedido;

    @Column(name = "cantidad")
    private String cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedidosBean")
    private pedidosBean pedidosBean;
}
