package mx.edu.utez.ExamenUII.controller;

import mx.edu.utez.ExamenUII.model.dto.DtoCoches;
import mx.edu.utez.ExamenUII.model.entity.CochesBean;
import mx.edu.utez.ExamenUII.service.ICoches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coches")
public class CochesController {
    @Autowired
    private ICoches cochesService;

    @PostMapping("/")
    public DtoCoches create(@RequestBody DtoCoches dtoCoches) {
        CochesBean cochesSave = cochesService.save(dtoCoches);
        return DtoCoches.builder().id_coches(cochesSave.getId_coches()).marca(cochesSave.getMarca())
                .modelo(cochesSave.getModelo()).color(cochesSave.getColor()).build();
    }


    @PutMapping("/")
    public DtoCoches update(@RequestBody DtoCoches dtoCoches) {
        CochesBean cochesUpdate = cochesService.save(dtoCoches);
        return DtoCoches.builder().id_coches(cochesUpdate.getId_coches()).marca(cochesUpdate.getMarca())
                .modelo(cochesUpdate.getModelo()).color(cochesUpdate.getColor()).build();
    }

    @DeleteMapping("/{id_coches}")
    public void delete(@PathVariable Integer id_coches) {
        CochesBean coches = cochesService.findById(id_coches);
        cochesService.delete(coches);
    }

    @GetMapping("/{id_coches}")
    public CochesBean showById(@PathVariable Integer id_coches) {
        return cochesService.findById(id_coches);
    }

    @GetMapping("/")
    public List<CochesBean> findAll() {
        return cochesService.findAll();
    }
}


