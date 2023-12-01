package mx.edu.utez.practicaExamen.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user")
public class userBean {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "employeeBean")
    private employeeBean employeeBean;

    @ManyToMany(mappedBy = "userBeanSet")
    Set<adminBean> adminBeanSet;
}
