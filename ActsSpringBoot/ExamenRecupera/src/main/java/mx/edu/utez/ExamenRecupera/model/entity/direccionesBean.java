package mx.edu.utez.ExamenRecupera.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "direcciones")
public class direccionesBean {
    @Id
    @Column(name = "id_direcciones")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_direcciones;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(mappedBy = "direccionesBean", cascade = CascadeType.ALL)
    private usuariosBean usuariosBean;
}
