package mx.edu.utez.ExamenUII.service.impl;

import mx.edu.utez.ExamenUII.model.dao.DaoCoches;
import mx.edu.utez.ExamenUII.model.dto.DtoCoches;
import mx.edu.utez.ExamenUII.model.entity.CochesBean;
import mx.edu.utez.ExamenUII.service.ICoches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplCoches implements ICoches {
    @Autowired
    private DaoCoches daoCoches;

    @Transactional
    @Override
    public CochesBean save(DtoCoches dtoCoches) {
        CochesBean coches = CochesBean.builder().id_coches(dtoCoches.getId_coches())
                .marca(dtoCoches.getMarca()).modelo(dtoCoches.getModelo())
                .color(dtoCoches.getColor()).km(dtoCoches.getKm()).build();
        return daoCoches.save(coches);
    }

    @Transactional(readOnly = true)
    @Override
    public CochesBean findById(Integer id_coches) {
        return daoCoches.findById(id_coches).orElse(null);
    }

    @Transactional
    @Override
    public void delete(CochesBean coches) {
        daoCoches.delete(coches);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CochesBean> findAll() {
        return (List<CochesBean>) daoCoches.findAll();
    }
}
