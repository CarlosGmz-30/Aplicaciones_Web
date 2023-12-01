package mx.edu.utez.ExamenRecupera.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class DtoComentarios {
    private Integer id_comentario;
    private String comentario;
}
