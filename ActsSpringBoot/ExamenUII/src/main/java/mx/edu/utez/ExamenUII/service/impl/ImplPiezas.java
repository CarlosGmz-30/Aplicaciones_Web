package mx.edu.utez.ExamenUII.service.impl;

import mx.edu.utez.ExamenUII.model.dao.DaoPiezas;
import mx.edu.utez.ExamenUII.model.dto.DtoPiezas;
import mx.edu.utez.ExamenUII.model.entity.PiezasBean;
import mx.edu.utez.ExamenUII.service.IPiezas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplPiezas implements IPiezas {
    @Autowired
    private DaoPiezas daoPiezas;

    @Transactional
    @Override
    public PiezasBean save(DtoPiezas dtoPiezas) {
        PiezasBean piezas = PiezasBean.builder().id_referencia(dtoPiezas.getId_referencia())
                .descripcion(dtoPiezas.getDescripcion()).precio(dtoPiezas.getPrecio()).
                stock(dtoPiezas.getStock()).build();
        return daoPiezas.save(piezas);
    }

    @Transactional(readOnly = true)
    @Override
    public PiezasBean findById(Integer id_referencia) {
        return daoPiezas.findById(id_referencia).orElse(null);
    }

    @Transactional
    @Override
    public void delete(PiezasBean piezas) {
        daoPiezas.delete(piezas);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PiezasBean> findAll() {
        return (List<PiezasBean>) daoPiezas.findAll();
    }
}
