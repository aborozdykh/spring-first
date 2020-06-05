package me.aborozdykh.springfirst.service;

import java.util.List;
import me.aborozdykh.springfirst.models.User;

public interface UserService {
    void add(User user);

    User get(Long id);

    List<User> listUsers();
}
