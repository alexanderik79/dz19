package org.example.service;

import org.example.entity.User;
import org.example.service.daoimplements.UserDaoImpl;

public class UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();

    public void save (User user){
        userDao.save(user);
    }
}
