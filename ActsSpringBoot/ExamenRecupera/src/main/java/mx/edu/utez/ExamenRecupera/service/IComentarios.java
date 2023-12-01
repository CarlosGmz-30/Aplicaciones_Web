package mx.edu.utez.ExamenRecupera.service;

import mx.edu.utez.ExamenRecupera.model.dto.DtoComentarios;
import mx.edu.utez.ExamenRecupera.model.entity.comentariosBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IComentarios {
    comentariosBean save(DtoComentarios comentarios);

    comentariosBean findById(Integer id_comentarios);

    void delete(comentariosBean comentarios);

    @Transactional(readOnly = true)
    List<comentariosBean> findAll();
}
