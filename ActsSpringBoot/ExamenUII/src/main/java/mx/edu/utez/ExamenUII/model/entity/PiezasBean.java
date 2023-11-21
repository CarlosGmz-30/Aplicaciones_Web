package mx.edu.utez.ExamenUII.model.entity;

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
@Table(name = "piezas")
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

    @ManyToMany
    @JoinTable(name = "DetallesReparacion",
            joinColumns = @JoinColumn(name = "id_referencia"),
            inverseJoinColumns = @JoinColumn(name = "id_reparaciones"))
    Set<ReparacionesBean> reparacionesBeanSet = new HashSet<>();
}
