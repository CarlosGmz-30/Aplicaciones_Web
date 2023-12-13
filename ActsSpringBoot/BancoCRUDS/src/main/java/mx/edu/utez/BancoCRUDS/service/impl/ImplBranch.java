package mx.edu.utez.BancoCRUDS.service.impl;

import mx.edu.utez.BancoCRUDS.model.dao.BranchDao;
import mx.edu.utez.BancoCRUDS.model.dto.BranchDto;
import mx.edu.utez.BancoCRUDS.model.entity.BranchBean;
import mx.edu.utez.BancoCRUDS.service.IBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplBranch implements IBranch {

    @Autowired
    private BranchDao branchDao;

    @Override
    @Transactional
    public BranchBean save(BranchDto branchDto) {
        BranchBean branch = BranchBean.builder()
                .idBranch(branchDto.getId_branch())
                .code(branchDto.getCode())
                .address(branchDto.getAddress())
                .name(branchDto.getName())
                .build();
        return branchDao.save(branch);
    }

    @Override
    @Transactional(readOnly = true)
    public BranchBean findById(Integer id) {
        return branchDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BranchBean> findAll() {
        return (List<BranchBean>) branchDao.findAll();
    }

    @Override
    @Transactional
    public void delete(BranchBean branch) {
        branchDao.delete(branch);
    }
}
