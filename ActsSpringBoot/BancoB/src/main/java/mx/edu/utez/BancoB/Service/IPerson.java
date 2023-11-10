package mx.edu.utez.BancoB.Service;

import mx.edu.utez.BancoB.Model.dto.DtoPerson;
import mx.edu.utez.BancoB.Model.entity.personBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPerson {
    personBean save(DtoPerson person);

    personBean findById(Integer id_person);

    void delete(personBean person);

    @Transactional(readOnly = true)
    List<personBean> findAll();
}
