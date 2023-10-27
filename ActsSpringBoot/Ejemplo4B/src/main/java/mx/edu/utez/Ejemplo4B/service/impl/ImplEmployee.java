package mx.edu.utez.Ejemplo4B.service.impl;

import mx.edu.utez.Ejemplo4B.model.dao.DaoEmployee;
import mx.edu.utez.Ejemplo4B.model.dto.DtoEmployee;
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
    public BeanEmployee save(DtoEmployee dtoEmployee) {
        BeanEmployee employee = BeanEmployee.builder().id(dtoEmployee.getId())
                .emp_name(dtoEmployee.getEmp_name()).ap1(dtoEmployee.getAp1())
                .ap2(dtoEmployee.getAp2()).salary(dtoEmployee.getSalary())
                .pos_type(dtoEmployee.getPos_type()).build();
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
