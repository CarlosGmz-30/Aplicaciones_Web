package mx.edu.utez.BancoB.Service;

import mx.edu.utez.BancoB.Model.dto.DtoClient;
import mx.edu.utez.BancoB.Model.entity.clientBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClient {
    clientBean save(DtoClient client);

    clientBean findById(Integer id_client);

    void delete(clientBean client);

    @Transactional(readOnly = true)
    List<clientBean> findAll();
}
