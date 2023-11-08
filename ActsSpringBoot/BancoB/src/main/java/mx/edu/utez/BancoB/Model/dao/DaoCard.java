package mx.edu.utez.BancoB.Model.dao;

import mx.edu.utez.BancoB.Model.entity.cardBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoCard extends CrudRepository<cardBean, Integer> {
}
