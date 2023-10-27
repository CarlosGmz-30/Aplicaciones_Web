package mx.edu.utez.Ejemplo4B.model.dto;

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

public class DtoEmployee {

    private Integer id;
    private String emp_name;
    private String ap1;
    private String ap2;
    private double salary;
    private String pos_type;
}
