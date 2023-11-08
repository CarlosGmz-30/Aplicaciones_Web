package mx.edu.utez.BancoB.Model.dao;

import mx.edu.utez.BancoB.Model.entity.branchBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoBranch extends CrudRepository<branchBean, Integer> {
}
