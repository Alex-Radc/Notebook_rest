package com.alexra.notebook.rest.dao;

import com.alexra.notebook.rest.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
