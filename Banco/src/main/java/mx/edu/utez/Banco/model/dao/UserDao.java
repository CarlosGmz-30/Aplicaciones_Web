package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.User.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserBean, Integer> {
    Optional<UserBean> findByUsername(String username);
}
