package org.example.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.User;
import org.example.service.daoimplements.UserDaoImpl;

public class UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();
    Logger logger = LogManager.getLogger(UserService.class);
    public void save (User user){
        if(user == null){
            logger.error("user is NULL!!!");
        }
        else {
            logger.warn("Start saving user " + user.getUsername() + ".");
            userDao.save(user);
            logger.info("User " + user.getUsername() + " was saved.");
        }
    }
}
