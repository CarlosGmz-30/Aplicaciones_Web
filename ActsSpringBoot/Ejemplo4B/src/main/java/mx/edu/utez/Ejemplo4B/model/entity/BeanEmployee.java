package mx.edu.utez.Ejemplo4B.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
//Getters/Setters
@AllArgsConstructor
// Constructor
@NoArgsConstructor
// Constructor vacío
@ToString
// Para imprimir el objeto en texto
@Builder
// Para construir un objeto Dto con los atributos que nosotros necesitemos nadamás
@Entity
// Para que esta clase se comporte como una entidad
@Table(name = "employee")
//             Nombre de base de datos

public class BeanEmployee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Esto solo para el indentificador
    private Integer id;
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "ap1")
    private String ap1;
    @Column(name = "ap2")
    private String ap2;
    @Column(name = "salary")
    private double salary;
    @Column(name = "pos_type")
    private String pos_type;


}
