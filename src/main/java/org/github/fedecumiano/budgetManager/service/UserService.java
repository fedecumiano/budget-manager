package org.github.fedecumiano.budgetManager.service;

import org.github.fedecumiano.budgetManager.model.User;
import org.github.fedecumiano.budgetManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getPass(String username) {
        List<User> users = userRepository.findByUsernameIgnoreCase(username);
        if (users.isEmpty()){
            return null;
        }
        else{
            return users.get(0).getPass();
        }
    }

    public void addUser(String username, String password) {
        User user = new User(username, password);
        userRepository.save(user);
    }

    public boolean userExists(String username){
        return !userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    public User getUser(String username){
        List<User> list = userRepository.findByUsernameIgnoreCase(username);
        if (list.isEmpty()){
            return null;
        }
        else{
            return list.get(0);
        }
    }


}
