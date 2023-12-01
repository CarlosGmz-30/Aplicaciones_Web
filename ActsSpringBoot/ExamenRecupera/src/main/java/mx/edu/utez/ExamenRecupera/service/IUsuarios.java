package mx.edu.utez.ExamenRecupera.service;

import mx.edu.utez.ExamenRecupera.model.dto.DtoUsuarios;
import mx.edu.utez.ExamenRecupera.model.entity.usuariosBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUsuarios {
    usuariosBean save(DtoUsuarios usuarios);

    usuariosBean findById(Integer id_usuarios);

    void delete(usuariosBean usuarios);

    @Transactional(readOnly = true)
    List<usuariosBean> findALL();
}
