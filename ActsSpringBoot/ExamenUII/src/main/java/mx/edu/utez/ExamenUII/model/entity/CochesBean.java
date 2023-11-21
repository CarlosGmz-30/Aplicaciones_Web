package mx.edu.utez.ExamenUII.model.entity;

import com.sun.jdi.PrimitiveValue;
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

    @OneToOne(mappedBy = "CochesBean", cascade = CascadeType.ALL)
    private ClientesBean ClientesBean;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "CochesBean", cascade = CascadeType.ALL)
    private Set<ReparacionesBean> reparacionesBeanSet = new HashSet<>();

}
