package mx.edu.utez.ExamenRecupera.controller;

import mx.edu.utez.ExamenRecupera.model.dto.DtoUsuarios;
import mx.edu.utez.ExamenRecupera.model.entity.usuariosBean;
import mx.edu.utez.ExamenRecupera.service.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recupera")
public class usuariosController {
    @Autowired
    private IUsuarios usuariosService;

    @PostMapping("/")
    public DtoUsuarios create(@RequestBody DtoUsuarios dtoUsuarios) {
        usuariosBean usuariosSave = usuariosService.save(dtoUsuarios);
        return DtoUsuarios.builder().id_usuarios(usuariosSave.getId_usuarios())
                .nombre(usuariosSave.getNombre())
                .email(usuariosSave.getEmail()).build();
    }

    @PutMapping("/")
    public DtoUsuarios update(@RequestBody DtoUsuarios dtoUsuarios) {
        usuariosBean usuariosUpdate = usuariosService.save(dtoUsuarios);
        return DtoUsuarios.builder().id_usuarios(usuariosUpdate.getId_usuarios())
                .nombre(usuariosUpdate.getNombre())
                .email(usuariosUpdate.getEmail()).build();
    }

    @DeleteMapping("{/id_usuarios}")
    public void delete(@PathVariable Integer id_usuarios) {
        usuariosBean usuarios = usuariosService.findById(id_usuarios);
        usuariosService.delete(usuarios);
    }

    @GetMapping("{/id_usuarios}")
    public usuariosBean showById(@PathVariable Integer id_usuarios) {
        return usuariosService.findById(id_usuarios);
    }

    @GetMapping("/")
    public List<usuariosBean> findAll() {
        return usuariosService.findALL();
    }


}
