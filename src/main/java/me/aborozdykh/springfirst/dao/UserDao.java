package me.aborozdykh.springfirst.dao;

import java.util.List;
import me.aborozdykh.springfirst.models.User;

public interface UserDao {
    void add(User user);

    User get(Long id);

    List<User> listUsers();
}
