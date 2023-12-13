package mx.edu.utez.BancoCRUDS.service;

import mx.edu.utez.BancoCRUDS.model.dto.PersonDto;
import mx.edu.utez.BancoCRUDS.model.entity.PersonBean;

import java.util.List;

public interface IPerson {
    PersonBean save(PersonDto person);

    PersonBean findById(Integer id);

    List<PersonBean> findAll();

    void delete(PersonBean person);
}
