package mx.edu.utez.ExamenRecupera.service.impl;

import mx.edu.utez.ExamenRecupera.model.dao.DaoUsuarios;
import mx.edu.utez.ExamenRecupera.model.dto.DtoUsuarios;
import mx.edu.utez.ExamenRecupera.model.entity.usuariosBean;
import mx.edu.utez.ExamenRecupera.service.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplUsuarios implements IUsuarios {
    @Autowired
    private DaoUsuarios daoUsuarios;

    @Transactional
    @Override
    public usuariosBean save(DtoUsuarios dtoUsuarios) {
        usuariosBean usuarios = usuariosBean.builder()
                .id_usuarios(dtoUsuarios.getId_usuarios())
                .nombre(dtoUsuarios.getNombre())
                .email(dtoUsuarios.getEmail()).build();
        return daoUsuarios.save(usuarios);
    }

    @Transactional(readOnly = true)
    @Override
    public usuariosBean findById(Integer id_usuarios) {
        return daoUsuarios.findById(id_usuarios).orElse(null);
    }

    @Override
    public void delete(usuariosBean usuarios) {
        daoUsuarios.delete(usuarios);
    }

    @Override
    public List<usuariosBean> findALL() {
        return (List<usuariosBean>) daoUsuarios.findAll();
    }
}
