package mx.edu.utez.ExamenRecupera.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "comentarios")
public class comentariosBean {
    @Id
    @Column(name = "id_comentarios")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_comentarios;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuariosBean")
    private usuariosBean usuariosBean;
}
