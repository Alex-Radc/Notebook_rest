package com.alexra.notebook.rest.dao;

import com.alexra.notebook.rest.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
//        List<User> allUsers = session.createQuery("from User", User.class)
//                .getResultList();
        Query<User> query =  session.createQuery("from User",
                User.class);
        List<User> allUsers = query.getResultList();
        LOGGER.error("List users  = "+ allUsers  );
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.error("Save user = "+user);
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        LOGGER.error("getUser = "+user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        LOGGER.error("deleteUser id = "+ id);
        query.executeUpdate();
    }

}
