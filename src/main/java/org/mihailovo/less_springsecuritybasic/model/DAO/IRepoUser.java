package org.mihailovo.less_springsecuritybasic.model.DAO;

import org.mihailovo.less_springsecuritybasic.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRepoUser extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
