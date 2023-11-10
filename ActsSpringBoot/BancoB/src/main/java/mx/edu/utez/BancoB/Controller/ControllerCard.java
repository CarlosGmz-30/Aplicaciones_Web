package mx.edu.utez.BancoB.Controller;

import mx.edu.utez.BancoB.Model.dto.DtoCard;
import mx.edu.utez.BancoB.Model.entity.cardBean;
import mx.edu.utez.BancoB.Service.ICard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/card")

public class ControllerCard {
    @Autowired
    private ICard cardService;

    @PostMapping("/")
    public DtoCard create(@RequestBody DtoCard dtoCard) {
        cardBean cardSave = cardService.save(dtoCard);
        return DtoCard.builder().id_card(cardSave.getId_card())
                .card_number(cardSave.getCard_number()).name_card(cardSave.getName_card())
                .credit_limit(cardSave.getCredit_limit()).build();
    }

    @PutMapping("/")
    public DtoCard update(@RequestBody DtoCard dtoCard) {
        cardBean cardUpdate = cardService.save(dtoCard);
        return DtoCard.builder().id_card(cardUpdate.getId_card())
                .card_number(cardUpdate.getCard_number()).name_card(cardUpdate.getName_card())
                .credit_limit(cardUpdate.getCredit_limit()).build();
    }

    @DeleteMapping("/{id_card}")
    public void delete(@PathVariable Integer id_card) {
        cardBean card = cardService.findById(id_card);
        cardService.delete(card);
    }

    @GetMapping("{id_card}")
    public cardBean showById(@PathVariable Integer id_card) {
        return cardService.findById(id_card);
    }

    @GetMapping("/")
    public List<cardBean> findAll() {
        return cardService.findAll();
    }
}
