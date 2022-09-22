package com.alexra.notebook.rest.service;

import com.alexra.notebook.rest.dao.UserDAO;
import com.alexra.notebook.rest.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    public  static final Logger LOGGER = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        LOGGER.error("UserServiceImpl getallUsers ");
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        LOGGER.error("UserServiceImpl saveUser  user = "+ user);
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        LOGGER.error("UserServiceImpl getUser where id = "+ id);
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        LOGGER.error("UserServiceImpl deleteUser where id = "+ id);
        userDAO.deleteUser(id);
    }
}
