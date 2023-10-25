package mx.edu.utez.Ejemplo4B.model.dao;

import mx.edu.utez.Ejemplo4B.model.entity.BeanEmployee;
import org.springframework.data.repository.CrudRepository;

public interface DaoEmployee extends CrudRepository <BeanEmployee, Integer> {

}
