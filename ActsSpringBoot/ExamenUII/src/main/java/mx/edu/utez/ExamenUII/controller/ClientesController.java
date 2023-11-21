package mx.edu.utez.ExamenUII.controller;

import mx.edu.utez.ExamenUII.model.dto.DtoClientes;
import mx.edu.utez.ExamenUII.model.entity.ClientesBean;
import mx.edu.utez.ExamenUII.service.IClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clientes")
public class ClientesController {
    @Autowired
    private IClientes clientesService;

    @PostMapping("/")
    public DtoClientes create(@RequestBody DtoClientes dtoClientes) {
        ClientesBean clientesSave = clientesService.save(dtoClientes);
        return DtoClientes.builder().id_cliente(clientesSave.getId_cliente()).apellidos(clientesSave.getApellidos())
                .nombre(clientesSave.getNombre()).direccion(clientesSave.getDireccion()).cp(clientesSave.getCp())
                .poblacion(clientesSave.getPoblacion()).telefono(clientesSave.getTelefono()).telefono2(clientesSave.getTelefono2()).build();
    }
}
































/*
package mx.edu.utez.BancoB.Controller;

import mx.edu.utez.BancoB.Model.dto.DtoBranch;
import mx.edu.utez.BancoB.Model.dto.DtoCard;
import mx.edu.utez.BancoB.Model.entity.branchBean;
import mx.edu.utez.BancoB.Model.entity.personBean;
import mx.edu.utez.BancoB.Service.IBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
public class ControllerBranch {

    @Autowired
    private IBranch branchService;

    @PostMapping("/")
    public DtoBranch create(@RequestBody DtoBranch dtoBranch) {
        branchBean branchSave = branchService.save(dtoBranch);
        return DtoBranch.builder().id_branch(branchSave.getId_branch())
                .name(branchSave.getName()).address(branchSave.getAddress())
                .code(branchSave.getCode()).build();
    }

    @PutMapping("/")
    public DtoBranch update(@RequestBody DtoBranch dtoBranch) {
        branchBean branchUpdate = branchService.save(dtoBranch);
        return DtoBranch.builder().id_branch(branchUpdate.getId_branch())
                .name(branchUpdate.getName()).address(branchUpdate.getAddress())
                .code(branchUpdate.getCode()).build();
    }

    @DeleteMapping("/{id_branch}")
    public void delete(@PathVariable Integer id_branch) {
        branchBean branch = branchService.findById(id_branch);
        branchService.delete(branch);
    }

    @GetMapping("/{id_branch}")
    public branchBean showById(@PathVariable Integer id_branch) {
        return branchService.findById(id_branch);
    }

    @GetMapping("/")
    public List<branchBean> findAll() {
        return branchService.findAll();
    }
}

 */