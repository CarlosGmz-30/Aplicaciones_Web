package mx.edu.utez.BancoCRUDS.model.dao;

import mx.edu.utez.BancoCRUDS.model.entity.CardBean;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<CardBean, Integer> {
}
