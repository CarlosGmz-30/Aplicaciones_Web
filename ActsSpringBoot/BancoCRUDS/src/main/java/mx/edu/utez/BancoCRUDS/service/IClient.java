package mx.edu.utez.BancoCRUDS.service;


import mx.edu.utez.BancoCRUDS.model.dto.ClientDto;
import mx.edu.utez.BancoCRUDS.model.entity.ClientBean;

import java.util.List;

public interface IClient {
    ClientBean save(ClientDto clientDto);

    ClientBean findById(Integer id);

    List<ClientBean> findAll();

    void delete(ClientBean clientBean);
}
