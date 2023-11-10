package mx.edu.utez.BancoB.Service.impl;

import mx.edu.utez.BancoB.Model.dao.DaoBranch;
import mx.edu.utez.BancoB.Model.dto.DtoBranch;
import mx.edu.utez.BancoB.Model.entity.branchBean;
import mx.edu.utez.BancoB.Service.IBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplBranch implements IBranch {
    @Autowired
    private DaoBranch daoBranch;

    @Transactional
    @Override
    public branchBean save(DtoBranch dtoBranch) {
        branchBean branch = branchBean.builder().id_branch(dtoBranch.getId_branch())
                .name(dtoBranch.getName()).address(dtoBranch.getAddress())
                .code(dtoBranch.getCode()).build();
        return daoBranch.save(branch);
    }

    @Transactional(readOnly = true)
    @Override
    public branchBean findById(Integer id_branch) {
        return daoBranch.findById(id_branch).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Transactional
    @Override
    public void delete(branchBean branch) {
        daoBranch.delete(branch);
    }

    @Transactional(readOnly = true)
    @Override
    public List<branchBean> findAll() {
        return (List<branchBean>) daoBranch.findAll();
    }
}
