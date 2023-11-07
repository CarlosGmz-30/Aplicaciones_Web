package mx.edu.utez.BancoB.Model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "employee")

public class employeeBean {
    @Id
    @Column(name = "id_employee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_employee;

    @Column(name = "employee_number")
    private Integer employee_number;

    @Column(name = "admition_date")
    private String admition_date;


    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_branch")
    private branchBean branchBean;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_person")
    private personBean personBean;

}
