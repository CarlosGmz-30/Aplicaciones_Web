package mx.edu.utez.ExamenUII.service;

import mx.edu.utez.ExamenUII.model.dto.DtoPiezas;
import mx.edu.utez.ExamenUII.model.entity.PiezasBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPiezas {
    PiezasBean save(DtoPiezas bean);

    PiezasBean findById(Integer id_referencia);

    void delete(PiezasBean piezas);


    @Transactional(readOnly = true)
    List<PiezasBean> findAll();

}
