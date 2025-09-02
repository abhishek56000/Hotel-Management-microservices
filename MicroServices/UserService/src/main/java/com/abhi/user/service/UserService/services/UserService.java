package com.abhi.user.service.UserService.services;


import com.abhi.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAllUser();

    User getUserByid(int id);

    void deleteUserById(int id);

}
