package mx.edu.utez.BancoCRUDS.model.dao;

import mx.edu.utez.BancoCRUDS.model.entity.BranchBean;
import org.springframework.data.repository.CrudRepository;

public interface BranchDao extends CrudRepository<BranchBean, Integer> {
}
