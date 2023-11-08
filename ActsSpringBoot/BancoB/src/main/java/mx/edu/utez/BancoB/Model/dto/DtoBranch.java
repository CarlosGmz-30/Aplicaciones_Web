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

public class DtoBranch {
    private Integer id_branch;
    private String name;
    private String address;
    private Integer code;
}
