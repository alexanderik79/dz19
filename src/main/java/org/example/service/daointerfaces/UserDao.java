package org.example.service.daointerfaces;

import org.example.entity.User;

import java.util.List;

public interface UserDao {
    void save (User user);
    User getUserById (int id);
    List<User> findAll();
}
