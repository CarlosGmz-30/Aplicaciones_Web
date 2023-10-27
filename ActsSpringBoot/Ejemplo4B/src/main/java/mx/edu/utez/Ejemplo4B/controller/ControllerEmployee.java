package mx.edu.utez.Ejemplo4B.controller;

import mx.edu.utez.Ejemplo4B.model.dto.DtoEmployee;
import mx.edu.utez.Ejemplo4B.model.entity.BeanEmployee;
import mx.edu.utez.Ejemplo4B.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

// Con este traemos las respuestas
@RestController
@RequestMapping("api/v1/employee")
// Mapeamos todos nuestros Request
public class ControllerEmployee {

    @Autowired

    // Mandamos llamar todos nuestros métodos
    private IEmployee employeeService;

    @PostMapping("/")
    public DtoEmployee create(@RequestBody DtoEmployee dtoEmployee) {
        BeanEmployee employeeSave = employeeService.save(dtoEmployee);
        return DtoEmployee.builder().id(employeeSave.getId())
                .emp_name(employeeSave.getEmp_name()).ap1(dtoEmployee.getAp1())
                .ap2(employeeSave.getAp2()).salary(dtoEmployee.getSalary())
                .pos_type(employeeSave.getPos_type()).build();
    }

    @PutMapping("/")
    public DtoEmployee update(@RequestBody DtoEmployee dtoEmployee) {
        BeanEmployee employeeUpdate = employeeService.save(dtoEmployee);
        return DtoEmployee.builder().id(employeeUpdate.getId())
                .emp_name(employeeUpdate.getEmp_name()).ap1(dtoEmployee.getAp1())
                .ap2(employeeUpdate.getAp2()).salary(dtoEmployee.getSalary())
                .pos_type(employeeUpdate.getPos_type()).build();
    }

    @DeleteMapping("/{idEmployee}")
    public void delete(@PathVariable Integer idEmployee) {
        BeanEmployee employee = employeeService.findById(idEmployee);
        employeeService.delete(employee);
    }

    @GetMapping("/{id}")
    public BeanEmployee showById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

}
