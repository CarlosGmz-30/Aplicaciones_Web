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
@Table(name = "usuarios")
public class usuariosBean {
    @Id
    @Column(name = "id_usuarios")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuarios;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_direcciones")
    private direccionesBean direccionesBean;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuariosBean", cascade = CascadeType.ALL)
    private Set<comentariosBean> comentariosBeanSet = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuariosBean", cascade = CascadeType.ALL)
    private Set<pedidosBean> pedidosBeanSet = new HashSet<>();


}
