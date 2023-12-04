package mx.edu.utez.ExamenRecupera.controller;

import mx.edu.utez.ExamenRecupera.model.dto.DtoComentarios;
import mx.edu.utez.ExamenRecupera.model.entity.comentariosBean;
import mx.edu.utez.ExamenRecupera.service.IComentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comentarios")
public class comentariosController {

    @Autowired
    private IComentarios comentariosService;

    @PostMapping("/")
    public DtoComentarios create(@RequestBody DtoComentarios dtoComentarios) {
        comentariosBean comentariosSave = comentariosService.save(dtoComentarios);
        return DtoComentarios.builder().id_comentario(comentariosSave.getId_comentarios())
                .comentario(comentariosSave.getComentario()).build();
    }

    @PutMapping("/")
    public DtoComentarios update(@RequestBody DtoComentarios dtoComentarios) {
        comentariosBean comentariosUpdate = comentariosService.save(dtoComentarios);
        return DtoComentarios.builder().id_comentario(comentariosUpdate.getId_comentarios())
                .comentario(comentariosUpdate.getComentario()).build();
    }

    @DeleteMapping("/{id_comentario}")
    public void delete(@PathVariable Integer id_comentario) {
        comentariosBean comentarios = comentariosService.findById(id_comentario);
        comentariosService.delete(comentarios);
    }

    @GetMapping("/{id_comentario}")
    public comentariosBean shobById(@PathVariable Integer id_comentario) {
        return comentariosService.findById(id_comentario);
    }

    @GetMapping("/")
    public List<comentariosBean> findAll() {
        return comentariosService.findAll();
    }
}
