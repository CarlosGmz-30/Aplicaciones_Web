package mx.edu.utez.Ejemplo4B.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
//Getters/Setters
@AllArgsConstructor
// Constructor
@NoArgsConstructor
// Constructor vacío
@ToString
// Para imprimir el objeto en texto
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
    @Column(name = "empName")
    private String empName;
    @Column(name = "ap1")
    private String ap1;
    @Column(name = "ap2")
    private String ap2;
    @Column(name = "salary")
    private double salary;
    @Column(name = "posType")
    private String posType;


}
