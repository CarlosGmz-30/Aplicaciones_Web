package mx.edu.utez.ExamenRecupera.model.dao;

import mx.edu.utez.ExamenRecupera.model.entity.comentariosBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoComentarios extends CrudRepository<comentariosBean, Integer> {
}
