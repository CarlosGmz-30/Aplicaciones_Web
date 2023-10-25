package mx.edu.utez.Ejemplo4B.service.impl;

import mx.edu.utez.Ejemplo4B.model.dao.DaoEmployee;
import mx.edu.utez.Ejemplo4B.model.entity.BeanEmployee;
import mx.edu.utez.Ejemplo4B.service.IEmployee;
import org.springframework.stereotype.Service;

// Este se va encargar de traer los métodos

@Service
public class ImplEmployee implements IEmployee {
    // Traemos los métodos
    private DaoEmployee daoEmployee;

    @Override
    public BeanEmployee save(BeanEmployee employee) {
        return daoEmployee.save(employee);
    }

    @Override
    public BeanEmployee findById(Integer id) {
        return daoEmployee.findById(id).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Override
    public void delete(BeanEmployee employee) {
        daoEmployee.delete(employee);
    }
}
