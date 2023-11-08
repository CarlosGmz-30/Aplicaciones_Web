package mx.edu.utez.BancoB.Model.entity;

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
@Table(name = "branch")

public class branchBean {
    @Id
    @Column(name = "id_branch")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_branch;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "code")
    private Integer code;

    @OneToOne(mappedBy = "branchBean", cascade = CascadeType.ALL)
    private employeeBean employeeBean;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branchBean", cascade = CascadeType.ALL)
    private Set<clientBean> clientBeanSet = new HashSet<>();
}
