package mx.edu.utez.ExamenRecupera.service.impl;

import mx.edu.utez.ExamenRecupera.model.dao.DaoComentarios;
import mx.edu.utez.ExamenRecupera.model.dto.DtoComentarios;
import mx.edu.utez.ExamenRecupera.model.entity.comentariosBean;
import mx.edu.utez.ExamenRecupera.service.IComentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplComentarios implements IComentarios {

    @Autowired
    private DaoComentarios daoComentarios;

    @Transactional
    @Override
    public comentariosBean save(DtoComentarios dtoComentarios) {
        comentariosBean comentarios = comentariosBean.builder()
                .id_comentarios(dtoComentarios.getId_comentario())
                .comentario(dtoComentarios.getComentario()).build();
        return daoComentarios.save(comentarios);
    }

    @Transactional(readOnly = true)
    @Override
    public comentariosBean findById(Integer id_comentarios) {
        return daoComentarios.findById(id_comentarios).orElse(null);
    }

    @Override
    public void delete(comentariosBean comentarios) {
        daoComentarios.delete(comentarios);
    }

    @Override
    public List<comentariosBean> findAll() {
        return (List<comentariosBean>) daoComentarios.findAll();
    }

}
