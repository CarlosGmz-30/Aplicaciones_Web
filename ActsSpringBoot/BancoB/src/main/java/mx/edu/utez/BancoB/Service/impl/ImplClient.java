package mx.edu.utez.BancoB.Service.impl;

import mx.edu.utez.BancoB.Model.dao.DaoClient;
import mx.edu.utez.BancoB.Model.dto.DtoClient;
import mx.edu.utez.BancoB.Model.entity.clientBean;
import mx.edu.utez.BancoB.Service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplClient implements IClient {
    @Autowired
    private DaoClient daoClient;

    @Transactional
    @Override
    public clientBean save(DtoClient dtoClient) {
        clientBean client = clientBean.builder().id_client(dtoClient.getId_client())
                .account(dtoClient.getAccount())
                .type(dtoClient.getType()).build();
        return daoClient.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public clientBean findById(Integer id_client) {
        return daoClient.findById(id_client).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Transactional
    @Override
    public void delete(clientBean client) {
        daoClient.delete(client);
    }

    @Override
    public List<clientBean> findAll() {
        return (List<clientBean>) daoClient.findAll();
    }
}
