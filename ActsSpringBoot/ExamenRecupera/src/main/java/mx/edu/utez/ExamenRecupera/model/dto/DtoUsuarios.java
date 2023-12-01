package mx.edu.utez.ExamenRecupera.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class DtoUsuarios {
    private Integer id_usuarios;
    private String nombre;
    private String email;
}

