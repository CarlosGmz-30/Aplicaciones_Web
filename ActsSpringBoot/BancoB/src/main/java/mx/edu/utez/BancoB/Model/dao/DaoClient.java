package mx.edu.utez.BancoB.Model.dao;

import mx.edu.utez.BancoB.Model.entity.clientBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoClient extends CrudRepository<clientBean, Integer> {
}
