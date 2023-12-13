package mx.edu.utez.BancoCRUDS.service;


import mx.edu.utez.BancoCRUDS.model.dto.BranchDto;
import mx.edu.utez.BancoCRUDS.model.entity.BranchBean;

import java.util.List;

public interface IBranch {
    BranchBean save(BranchDto branch);

    BranchBean findById(Integer id);

    List<BranchBean> findAll();

    void delete(BranchBean branch);
}
