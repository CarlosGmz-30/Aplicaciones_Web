package mx.edu.utez.ExamenUII.service;

import mx.edu.utez.ExamenUII.model.dto.DtoCoches;
import mx.edu.utez.ExamenUII.model.entity.ClientesBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClientes {
    ClientesBean save(DtoCoches bean);

    ClientesBean findById(Integer id_cliente);

    void delete(ClientesBean clientes);


    @Transactional(readOnly = true)
    List<ClientesBean> findAll();
}
