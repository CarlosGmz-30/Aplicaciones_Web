package mx.edu.utez.BancoCRUDS.model.dao;

import mx.edu.utez.BancoCRUDS.model.entity.EmployeeBean;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<EmployeeBean, Integer> {
}
