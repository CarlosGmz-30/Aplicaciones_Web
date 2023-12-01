package mx.edu.utez.ExamenRecupera.service;

import mx.edu.utez.ExamenRecupera.model.dto.claseDto;
import mx.edu.utez.ExamenRecupera.model.entity.claseBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClase {
    claseBean save(claseDto clase);

    claseBean findById(Integer id);

    void delete(claseBean clase);

    @Transactional(readOnly = true)
    List<claseBean> findAll();
}
