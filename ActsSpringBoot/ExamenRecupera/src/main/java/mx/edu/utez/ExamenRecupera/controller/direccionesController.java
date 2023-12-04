package mx.edu.utez.ExamenRecupera.controller;

import mx.edu.utez.ExamenRecupera.model.dto.DtoDirecciones;
import mx.edu.utez.ExamenRecupera.model.entity.direccionesBean;
import mx.edu.utez.ExamenRecupera.service.IDirecciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/direcciones")
public class direccionesController {

    @Autowired
    private IDirecciones direccionesService;

    @PostMapping("/")
    public DtoDirecciones create(@RequestBody DtoDirecciones dtoDirecciones) {
        direccionesBean direccionesSave = direccionesService.save(dtoDirecciones);
        return DtoDirecciones.builder().id_direcciones(direccionesSave.getId_direcciones())
                .direccion(direccionesSave.getDireccion()).build();
    }

    @PutMapping("/")
    public DtoDirecciones uodate(@RequestBody DtoDirecciones dtoDirecciones) {
        direccionesBean direccionesUpdate = direccionesService.save(dtoDirecciones);
        return DtoDirecciones.builder().id_direcciones(direccionesUpdate.getId_direcciones())
                .direccion(direccionesUpdate.getDireccion()).build();
    }

    @DeleteMapping("/{id_direcciones}")
    public void delete(@PathVariable Integer id_direcciones) {
        direccionesBean direcciones = direccionesService.findById(id_direcciones);
        direccionesService.delete(direcciones);
    }

    @GetMapping("/{id_direcciones}")
    public direccionesBean shobById(@PathVariable Integer id_direcciones) {
        return direccionesService.findById(id_direcciones);
    }

    @GetMapping("/")
    public List<direccionesBean> findAll() {
        return direccionesService.findAll();
    }
}
