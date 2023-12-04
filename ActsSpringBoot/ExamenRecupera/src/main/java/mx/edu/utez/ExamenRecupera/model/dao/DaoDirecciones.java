package mx.edu.utez.ExamenRecupera.model.dao;

import mx.edu.utez.ExamenRecupera.model.entity.direccionesBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoDirecciones extends CrudRepository<direccionesBean, Integer> {
}
