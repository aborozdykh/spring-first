package me.aborozdykh.springfirst.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import me.aborozdykh.springfirst.dao.UserDao;
import me.aborozdykh.springfirst.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.openSession()
                .createQuery("from User", User.class);
        return query.getResultList();
    }
}
