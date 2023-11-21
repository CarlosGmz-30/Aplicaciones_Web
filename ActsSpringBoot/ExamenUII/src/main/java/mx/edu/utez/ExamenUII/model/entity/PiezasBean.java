package mx.edu.utez.ExamenUII.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "pizas")
public class PiezasBean {
    @Id
    @Column(name = "id_referencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_referencia;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "stock")
    private Integer stock;
}
