package mx.edu.utez.BancoB.Model.dao;

import mx.edu.utez.BancoB.Model.entity.personBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoPerson extends CrudRepository<personBean, Integer> {
}
