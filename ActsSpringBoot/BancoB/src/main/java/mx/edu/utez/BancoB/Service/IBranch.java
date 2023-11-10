package mx.edu.utez.BancoB.Service;

import mx.edu.utez.BancoB.Model.dto.DtoBranch;
import mx.edu.utez.BancoB.Model.entity.branchBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBranch {
    branchBean save(DtoBranch bean);

    branchBean findById(Integer id_branch);

    void delete(branchBean branch);

    @Transactional(readOnly = true)
    List<branchBean> findAll();

}
