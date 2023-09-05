package org.example.service;

import org.example.entity.User;

public class UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();

    public void save (User user){
        userDao.save(user);
    }
}
