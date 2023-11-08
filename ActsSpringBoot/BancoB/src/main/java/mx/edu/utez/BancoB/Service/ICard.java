package mx.edu.utez.BancoB.Service;

import mx.edu.utez.BancoB.Model.dto.DtoCard;
import mx.edu.utez.BancoB.Model.entity.cardBean;

public interface ICard {
    cardBean save(DtoCard card);

    cardBean findById(Integer id_card);

    void delete(cardBean card);
}
