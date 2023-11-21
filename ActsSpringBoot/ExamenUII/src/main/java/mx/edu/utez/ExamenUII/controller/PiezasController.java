package mx.edu.utez.ExamenUII.controller;

import mx.edu.utez.ExamenUII.model.dto.DtoPiezas;
import mx.edu.utez.ExamenUII.model.entity.PiezasBean;
import mx.edu.utez.ExamenUII.service.IPiezas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/piezas")
public class PiezasController {
    @Autowired
    private IPiezas piezasService;

    @PostMapping("/")
    public DtoPiezas create(@RequestBody DtoPiezas dtoPiezas) {
        PiezasBean piezasSave = piezasService.save(dtoPiezas);
        return DtoPiezas.builder().id_referencia(piezasSave.getId_referencia()).descripcion(piezasSave.getDescripcion())
                .precio(piezasSave.getPrecio()).stock(piezasSave.getStock()).build();
    }

    @PutMapping("/")
    public DtoPiezas update(@RequestBody DtoPiezas dtoPiezas) {
        PiezasBean piezasUpdate = piezasService.save(dtoPiezas);
        return DtoPiezas.builder().id_referencia(piezasUpdate.getId_referencia())
                .descripcion(piezasUpdate.getDescripcion()).precio(piezasUpdate.getPrecio())
                .stock(piezasUpdate.getStock()).build();
    }

    @DeleteMapping("/{id_referencia}")
    public void delete(@PathVariable Integer id_referencia) {
        PiezasBean piezas = piezasService.findById(id_referencia);
        piezasService.delete(piezas);
    }

    @GetMapping("/{id_referencia}")
    public PiezasBean showById(@PathVariable Integer id_referencia) {
        return piezasService.findById(id_referencia);
    }

    @GetMapping("/")
    public List<PiezasBean> findAll() {
        return piezasService.findAll();
    }
}
