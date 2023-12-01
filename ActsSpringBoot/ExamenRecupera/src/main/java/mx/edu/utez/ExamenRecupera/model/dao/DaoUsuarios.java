package mx.edu.utez.ExamenRecupera.model.dao;

import mx.edu.utez.ExamenRecupera.model.entity.usuariosBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoUsuarios extends CrudRepository<usuariosBean, Integer> {
}
