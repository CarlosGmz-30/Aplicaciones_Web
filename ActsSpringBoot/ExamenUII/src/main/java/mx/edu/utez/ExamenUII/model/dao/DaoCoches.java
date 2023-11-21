package mx.edu.utez.ExamenUII.model.dao;

import mx.edu.utez.ExamenUII.model.entity.CochesBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoCoches extends CrudRepository<CochesBean, Integer> {
}


