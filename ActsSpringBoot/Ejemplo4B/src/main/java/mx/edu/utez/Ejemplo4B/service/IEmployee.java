package mx.edu.utez.Ejemplo4B.service;

import mx.edu.utez.Ejemplo4B.model.entity.BeanEmployee;

public interface IEmployee {

    BeanEmployee save(BeanEmployee employee);
    BeanEmployee findById(Integer id);
    void delete(BeanEmployee employee);
}
