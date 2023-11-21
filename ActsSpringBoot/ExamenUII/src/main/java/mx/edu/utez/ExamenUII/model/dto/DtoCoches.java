package mx.edu.utez.ExamenUII.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DtoCoches {
    private Integer id_coches;
    private String marca;
    private String modelo;
    private String color;
    private Integer km;
}
