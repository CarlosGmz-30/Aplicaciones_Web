package mx.edu.utez.BancoB.Service.impl;

import mx.edu.utez.BancoB.Model.dao.DaoPerson;
import mx.edu.utez.BancoB.Model.dto.DtoPerson;
import mx.edu.utez.BancoB.Model.entity.personBean;
import mx.edu.utez.BancoB.Service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImplPerson implements IPerson {
    @Autowired
    private DaoPerson daoPerson;

    @Transactional
    @Override
    public personBean save(DtoPerson dtoPerson) {
        personBean person = personBean.builder().id_person(dtoPerson.getId_person())
                .name(dtoPerson.getName()).api1(dtoPerson.getApi1()).api2(dtoPerson.getApi2())
                .birthdate(dtoPerson.getBirthdate()).address(dtoPerson.getAddress()).build();
        return daoPerson.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public personBean findById(Integer id_person) {
        return daoPerson.findById(id_person).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Transactional
    @Override
    public void delete(personBean person) {
        daoPerson.delete(person);
    }

}
