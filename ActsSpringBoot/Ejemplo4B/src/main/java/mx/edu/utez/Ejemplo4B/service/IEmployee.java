package mx.edu.utez.Ejemplo4B.service;

import mx.edu.utez.Ejemplo4B.model.dto.DtoEmployee;
import mx.edu.utez.Ejemplo4B.model.entity.BeanEmployee;

public interface IEmployee {

    BeanEmployee save(DtoEmployee employee);
    BeanEmployee findById(Integer id);
    void delete(BeanEmployee employee);
}
