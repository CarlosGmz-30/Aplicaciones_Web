package mx.edu.utez.BancoB.Model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "client")

public class clientBean {
    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_client;

    @Column(name = "account")
    private String account;

    @Column(name = "type")
    private String type;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_person")
    private personBean personBean;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_branch")
    private branchBean branchBean;
}
