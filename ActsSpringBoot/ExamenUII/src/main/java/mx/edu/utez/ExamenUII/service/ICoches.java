package mx.edu.utez.ExamenUII.service;

import mx.edu.utez.ExamenUII.model.dto.DtoCoches;
import mx.edu.utez.ExamenUII.model.entity.CochesBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICoches {
    CochesBean save(DtoCoches bean);

    CochesBean findById(Integer id_coches);

    void delete(CochesBean coches);


    @Transactional(readOnly = true)
    List<CochesBean> findAll();
}
