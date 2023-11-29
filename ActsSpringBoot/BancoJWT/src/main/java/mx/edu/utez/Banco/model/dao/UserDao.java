package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.user.UserBean;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<UserBean, Integer> {
    Optional<UserBean> findByUsername(String username);
}
