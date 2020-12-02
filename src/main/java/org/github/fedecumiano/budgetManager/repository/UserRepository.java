package org.github.fedecumiano.budgetManager.repository;

import org.github.fedecumiano.budgetManager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByUsernameIgnoreCase(String userName);
}
