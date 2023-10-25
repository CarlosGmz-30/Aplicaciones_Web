package mx.edu.utez.Ejemplo4B.service.impl;

import mx.edu.utez.Ejemplo4B.model.dao.DaoEmployee;
import mx.edu.utez.Ejemplo4B.model.entity.BeanEmployee;
import mx.edu.utez.Ejemplo4B.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Este se va encargar de traer los métodos

@Service
public class ImplEmployee implements IEmployee {
    @Autowired
    // Traemos los métodos
    private DaoEmployee daoEmployee;
    @Transactional
    @Override
    public BeanEmployee save(BeanEmployee employee) {
        return daoEmployee.save(employee);
    }
    @Transactional(readOnly = true)
    @Override
    public BeanEmployee findById(Integer id) {
        return daoEmployee.findById(id).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Transactional
    @Override
    public void delete(BeanEmployee employee) {
        daoEmployee.delete(employee);
    }
}
