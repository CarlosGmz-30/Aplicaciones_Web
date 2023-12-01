package mx.edu.utez.practicaExamen.model.entity;

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

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @OneToOne(mappedBy = "employeeBean", cascade = CascadeType.ALL)
    private userBean userBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminBean")
    private adminBean adminBean;
}
