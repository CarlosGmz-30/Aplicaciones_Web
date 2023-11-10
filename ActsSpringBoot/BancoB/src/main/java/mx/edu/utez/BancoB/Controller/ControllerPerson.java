package mx.edu.utez.BancoB.Controller;

import mx.edu.utez.BancoB.Model.dto.DtoPerson;
import mx.edu.utez.BancoB.Model.entity.personBean;
import mx.edu.utez.BancoB.Service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Con este traemos las respuestas
@RestController
@RequestMapping("api/v1/person")
// Mapeamos todos nuestros Request
public class ControllerPerson {

    @Autowired
    private IPerson personService;

    @PostMapping("/")
    public DtoPerson create(@RequestBody DtoPerson dtoPerson) {
        personBean personSave = personService.save(dtoPerson);
        return DtoPerson.builder().id_person(personSave.getId_person())
                .name(personSave.getName()).api1(personSave.getApi1()).api2(personSave.getApi2())
                .birthdate(personSave.getBirthdate()).address(personSave.getAddress()).build();
    }

    @PutMapping("/")
    public DtoPerson update(@RequestBody DtoPerson dtoPerson) {
        personBean personUpdate = personService.save(dtoPerson);
        return DtoPerson.builder().id_person(personUpdate.getId_person())
                .name(personUpdate.getName()).api1(personUpdate.getApi1()).api2(personUpdate.getApi2())
                .birthdate(personUpdate.getBirthdate()).address(personUpdate.getAddress()).build();
    }

    @DeleteMapping("/{id_person}")
    public void delete(@PathVariable Integer id_person) {
        personBean person = personService.findById(id_person);
        personService.delete(person);
    }

    @GetMapping("/{id_person}")
    public personBean showById(@PathVariable Integer id_person) {
        return personService.findById(id_person);
    }
}
