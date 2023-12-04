package mx.edu.utez.ExamenRecupera.service.impl;

import com.sun.jdi.PrimitiveValue;
import mx.edu.utez.ExamenRecupera.model.dao.DaoDirecciones;
import mx.edu.utez.ExamenRecupera.model.dao.DaoUsuarios;
import mx.edu.utez.ExamenRecupera.model.dto.DtoDirecciones;
import mx.edu.utez.ExamenRecupera.model.entity.direccionesBean;
import mx.edu.utez.ExamenRecupera.service.IDirecciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplDirecciones implements IDirecciones {

    @Autowired
    private DaoDirecciones daoDirecciones;

    @Transactional
    @Override
    public direccionesBean save(DtoDirecciones dtoDirecciones) {
        direccionesBean direcciones = direccionesBean.builder()
                .id_direcciones(dtoDirecciones.getId_direcciones())
                .direccion(dtoDirecciones.getDireccion()).build();
        return daoDirecciones.save(direcciones);
    }

    @Transactional(readOnly = true)
    @Override
    public direccionesBean findById(Integer id_direcciones) {
        return daoDirecciones.findById(id_direcciones).orElse(null);
    }

    @Override
    public void delete(direccionesBean direcciones) {
        daoDirecciones.delete(direcciones);
    }

    @Override
    public List<direccionesBean> findAll() {
        return (List<direccionesBean>) daoDirecciones.findAll();
    }
}
