package mx.edu.utez.ExamenUII.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "clientes")
public class ClientesBean {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "cp")
    private Integer cp;

    @Column(name = "población")
    private Integer poblacion;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "telefono2")
    private Integer telefono2;

}



























/*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branchBean", cascade = CascadeType.ALL)
    private Set<clientBean> clientBeanSet = new HashSet<>();
}
 */