package mx.edu.utez.BancoB.Model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "person")

public class personBean {
    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_person;

    @Column(name = "name")
    private String name;

    @Column(name = "api1")
    private String api1;

    @Column(name = "api2")
    private String api2;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "personBean", cascade = CascadeType.ALL)
    private clientBean clientBean;

    @OneToOne(mappedBy = "personBean", cascade = CascadeType.ALL)
    private employeeBean employeeBean;
}
