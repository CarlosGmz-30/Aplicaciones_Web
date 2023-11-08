package mx.edu.utez.BancoB.Service.impl;

import mx.edu.utez.BancoB.Model.dao.DaoCard;
import mx.edu.utez.BancoB.Model.dto.DtoCard;
import mx.edu.utez.BancoB.Model.entity.cardBean;
import mx.edu.utez.BancoB.Service.ICard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImplCard implements ICard {
    @Autowired
    // Traemos los métodos
    private DaoCard daoCard;

    @Transactional
    @Override
    public cardBean save(DtoCard dtoCard) {
        cardBean card = cardBean.builder().id_card(dtoCard.getId_card())
                .card_number(dtoCard.getCard_number()).name_card(dtoCard.getName_card())
                .credit_limit(dtoCard.getCredit_limit()).build();
        return daoCard.save(card);
    }

    @Transactional(readOnly = true)
    @Override
    public cardBean findById(Integer id_card) {
        return daoCard.findById(id_card).orElse(null);
        //                              Por si no existe returna un nulo
    }

    @Transactional
    @Override
    public void delete(cardBean card) {
        daoCard.delete(card);
    }
}
