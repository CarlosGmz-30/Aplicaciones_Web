package mx.edu.utez.BancoB.Model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "card")

public class cardBean {
    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_card;

    @Column(name = "name_card")
    private String name_card;

    @Column(name = "credit_limit")
    private double credit_limit;

    @Column(name = "card_number")
    private String card_number;

}
