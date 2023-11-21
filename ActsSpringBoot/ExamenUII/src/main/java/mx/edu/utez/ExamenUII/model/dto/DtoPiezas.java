package mx.edu.utez.ExamenUII.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DtoPiezas {
    private Integer id_referencia;
    private String descripcion;
    private Integer precio;
    private Integer stock;
}
