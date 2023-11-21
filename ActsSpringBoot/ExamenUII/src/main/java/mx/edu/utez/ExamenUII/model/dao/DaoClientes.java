package mx.edu.utez.ExamenUII.model.dao;

import mx.edu.utez.ExamenUII.model.entity.ClientesBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoClientes extends CrudRepository<ClientesBean, Integer> {
}