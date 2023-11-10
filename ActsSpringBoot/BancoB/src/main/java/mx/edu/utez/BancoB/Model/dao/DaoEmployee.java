package mx.edu.utez.BancoB.Model.dao;

import mx.edu.utez.BancoB.Model.entity.employeeBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoEmployee extends CrudRepository<employeeBean, Integer> {
}
