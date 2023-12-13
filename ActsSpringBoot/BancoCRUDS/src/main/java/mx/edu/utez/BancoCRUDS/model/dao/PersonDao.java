package mx.edu.utez.BancoCRUDS.model.dao;

import mx.edu.utez.BancoCRUDS.model.entity.PersonBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<PersonBean, Integer> {
}
