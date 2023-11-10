package mx.edu.utez.BancoB.Service;

import mx.edu.utez.BancoB.Model.dto.DtoEmployee;
import mx.edu.utez.BancoB.Model.entity.employeeBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployee {
    employeeBean save(DtoEmployee employee);

    employeeBean findById(Integer id_employee);

    void delete(employeeBean employee);

    @Transactional(readOnly = true)
    List<employeeBean> findAll();
}