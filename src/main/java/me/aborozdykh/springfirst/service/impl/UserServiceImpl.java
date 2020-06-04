package me.aborozdykh.springfirst.service.impl;

import java.util.List;
import me.aborozdykh.springfirst.dao.UserDao;
import me.aborozdykh.springfirst.models.User;
import me.aborozdykh.springfirst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
