package mx.edu.utez.practicaExamen.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "admin")
public class adminBean {
    @Id
    @Column(name = "id_admin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_admin;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminBean", cascade = CascadeType.ALL)
    private Set<employeeBean> employeeBeanSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "intermediable_table",
            joinColumns = @JoinColumn(name = "adminBean"),
            inverseJoinColumns = @JoinColumn(name = "userBean"))
    Set<userBean> userBeanSet = new HashSet<>();
}
