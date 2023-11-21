package mx.edu.utez.ExamenUII.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "coches")
public class CochesBean {
    @Id
    @Column(name = "id_coches")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_coches;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @Column(name = "km")
    private Integer km;

}
