package net.nel.il.service;

import net.nel.il.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    public boolean isUserExists(String username){
        return userDAO.isUserExists(username);
    }

    @Transactional
    public void registerUser(String username, String password){
        userDAO.registerUser(username, password);
    }
}
