package mx.edu.utez.ExamenRecupera.service.impl;

import mx.edu.utez.ExamenRecupera.model.dao.claseDao;
import mx.edu.utez.ExamenRecupera.model.dto.claseDto;
import mx.edu.utez.ExamenRecupera.model.entity.claseBean;
import mx.edu.utez.ExamenRecupera.service.IClase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplClase implements IClase {

    @Autowired
    private claseDao claseDao;

    @Transactional
    @Override
    public claseBean save(claseDto claseDto) {
        claseBean clase = claseBean.builder().id(claseDto.getId()).build();
        return claseDao.save(clase);
    }

    @Transactional(readOnly = true)
    @Override
    public claseBean findById(Integer id) {
        return claseDao.findById(id).orElse(null);
    }

    @Override
    public void delete(claseBean clase) {
        claseDao.delete(clase);
    }

    @Transactional(readOnly = true)
    @Override
    public List<claseBean> findAll() {

        return (List<claseBean>) claseDao.findAll();
    }
}