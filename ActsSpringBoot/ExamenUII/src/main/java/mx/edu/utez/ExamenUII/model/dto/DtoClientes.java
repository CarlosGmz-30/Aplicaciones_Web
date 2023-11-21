package mx.edu.utez.ExamenUII.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DtoClientes {
    private Integer id_cliente;
    private String apellidos;
    private String nombre;
    private String direccion;
    private Integer cp;
    private Integer poblacion;
    private Integer telefono;
    private Integer telefono2;
}


























/*
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
 */