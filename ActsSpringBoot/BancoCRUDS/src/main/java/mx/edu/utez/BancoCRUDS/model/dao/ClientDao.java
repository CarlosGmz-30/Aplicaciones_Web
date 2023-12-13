package mx.edu.utez.BancoCRUDS.model.dao;

import mx.edu.utez.BancoCRUDS.model.entity.ClientBean;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<ClientBean, Integer> {
}
