package mx.edu.utez.ExamenUII.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "reparaciones")
public class ReparacionesBean {
    @Id
    @Column(name = "id_reparaciones")
    private Integer id_reparaciones;

    @Column(name = "matricula")
    private Integer matricula;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_entrada")
    private String fecha_entrada;


    @Column(name = "fecha_salida")
    private String fecha_salida;

    @Column(name = "horas")
    private String horas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coches")
    private CochesBean CochesBean;

    @ManyToMany(mappedBy = "ReparacionesBeanSet")
    Set<PiezasBean> piezasBeanSet;
}
