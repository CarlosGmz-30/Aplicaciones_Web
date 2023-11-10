package mx.edu.utez.BancoB.Service.impl;

import mx.edu.utez.BancoB.Model.dao.DaoEmployee;
import mx.edu.utez.BancoB.Model.dto.DtoEmployee;
import mx.edu.utez.BancoB.Model.entity.employeeBean;
import mx.edu.utez.BancoB.Service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplEmployee implements IEmployee {
    @Autowired
    private DaoEmployee daoEmployee;

    @Transactional
    @Override
    public employeeBean save(DtoEmployee dtoEmployee) {
        employeeBean employee = employeeBean.builder().id_employee(dtoEmployee.getId_employee())
                .employee_number(dtoEmployee.getEmployee_number())
                .admition_date(dtoEmployee.getAdmition_date()).build();
        return daoEmployee.save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public employeeBean findById(Integer id_employee) {
        return daoEmployee.findById(id_employee).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Transactional
    @Override
    public void delete(employeeBean employee) {
        daoEmployee.delete(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<employeeBean> findAll() {
        return (List<employeeBean>) daoEmployee.findAll();
    }
}
