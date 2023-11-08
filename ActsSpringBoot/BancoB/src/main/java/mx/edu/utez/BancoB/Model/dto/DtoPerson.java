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

public class DtoPerson {
    private Integer id_person;
    private String name;
    private String api1;
    private String api2;
    private String birthdate;
    private String address;

}
