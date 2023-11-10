package mx.edu.utez.BancoB.Model.dto;

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
    private Integer id_employee;
    private Integer employee_number;
    private String admition_date;
}
