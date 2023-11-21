package mx.edu.utez.ExamenUII.model.dao;

import mx.edu.utez.ExamenUII.model.entity.PiezasBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoPiezas extends CrudRepository<PiezasBean, Integer> {
}
