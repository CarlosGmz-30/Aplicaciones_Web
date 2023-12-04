package mx.edu.utez.ExamenRecupera.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class DtoDirecciones {
    private Integer id_direcciones;
    private String direccion;
    private Integer id_usuario;
}
