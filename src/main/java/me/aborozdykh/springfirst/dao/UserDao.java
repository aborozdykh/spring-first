package me.aborozdykh.springfirst.dao;

import java.util.List;
import me.aborozdykh.springfirst.models.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
