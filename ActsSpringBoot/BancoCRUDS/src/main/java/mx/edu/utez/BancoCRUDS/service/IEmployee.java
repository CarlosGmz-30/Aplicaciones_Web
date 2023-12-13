package mx.edu.utez.BancoCRUDS.service;


import mx.edu.utez.BancoCRUDS.model.dto.EmployeeDto;
import mx.edu.utez.BancoCRUDS.model.entity.EmployeeBean;

import java.util.List;

public interface IEmployee {
    EmployeeBean save(EmployeeDto employeeDto);

    EmployeeBean findById(Integer id);

    List<EmployeeBean> findAll();

    void delete(EmployeeBean employeeBean);
}
