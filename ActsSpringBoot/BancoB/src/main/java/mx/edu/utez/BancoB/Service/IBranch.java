package mx.edu.utez.BancoB.Service;

import mx.edu.utez.BancoB.Model.dto.DtoBranch;
import mx.edu.utez.BancoB.Model.entity.branchBean;

public interface IBranch {
    branchBean save(DtoBranch bean);

    branchBean findById(Integer id_branch);

    void delete(branchBean branch);
}
