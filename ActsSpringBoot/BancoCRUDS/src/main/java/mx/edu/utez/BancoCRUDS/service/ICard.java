package mx.edu.utez.BancoCRUDS.service;

import mx.edu.utez.BancoCRUDS.model.dto.CardDto;
import mx.edu.utez.BancoCRUDS.model.entity.CardBean;

import java.util.List;

public interface ICard {
    CardBean save(CardDto card);

    CardBean findById(Integer id);

    List<CardBean> findAll();

    void delete(CardBean card);
}
