package mx.edu.utez.ExamenRecupera.controller;

import mx.edu.utez.ExamenRecupera.model.dto.claseDto;
import mx.edu.utez.ExamenRecupera.model.entity.claseBean;
import mx.edu.utez.ExamenRecupera.service.IClase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clase")
public class claseController {

    @Autowired
    private IClase claseService;

    @PostMapping("/")
    public claseDto create(@RequestBody claseDto dtoClase) {
        claseBean claseSave = claseService.save(dtoClase);
        return claseDto.builder().id(claseSave.getId()).build();
    }

    @PutMapping("/")
    public claseDto update(@RequestBody claseDto dtoClase) {
        claseBean claseUpdate = claseService.save(dtoClase);
        return claseDto.builder().id(claseUpdate.getId()).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        claseBean clase = claseService.findById(id);
        claseService.delete(clase);
    }

    @GetMapping("{id}")
    public claseBean shobById(@PathVariable Integer id) {
        return claseService.findById(id);
    }

    @GetMapping("/")
    public List<claseBean> findAll() {
        return claseService.findAll();
    }
}
