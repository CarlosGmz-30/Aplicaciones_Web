package mx.edu.utez.ExamenRecupera.service;

import mx.edu.utez.ExamenRecupera.model.dto.DtoDirecciones;
import mx.edu.utez.ExamenRecupera.model.entity.direccionesBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDirecciones {
    direccionesBean save(DtoDirecciones direcciones);

    direccionesBean findById(Integer id_direcciones);

    void delete(direccionesBean direcciones);

    @Transactional(readOnly = true)
    List<direccionesBean> findAll();
}
