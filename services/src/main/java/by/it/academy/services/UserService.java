/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by.it.academy.services;

import by.it.academy.daoImpl.UserDaoImpl;
import by.it.academy.pojos.User;

import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public class UserService {

    private static UserService instance;
    private UserService() {
    }
    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();

    public void add(User user) {
        userDaoImpl.add(user);
    }

    public List<User> getAll() {
        return userDaoImpl.getAll();
    }

    public User getByLoginAndPassword(User user) {
        return userDaoImpl.getByLoginAndPassword(user);
    }

    public long getIdUser(User user) {
        return userDaoImpl.getIdUser(user);
    }

    public String userInfoTariff(User user) {
        return userDaoImpl.userInfoTariff(user);
    }

    public int userInfoAccount(User user) {
        return userDaoImpl.userInfoAccount(user);
    }

    public void addUserTariffById(User user,  long tariff_id) {
        userDaoImpl.addUserTariffById(user, tariff_id);
    }

    public void addUserService(User user, long serviceId) {
        userDaoImpl.addUserService(user, serviceId);
    }

    public void changeUserAccount(User user, int changeAccount) {
        userDaoImpl.changeUserAccount(user, changeAccount);
    }

    public void deleteUserService(User user, long serviceId) {
        userDaoImpl.deleteUserService(user, serviceId);
    }

    public List<User> getAllSort(String operation, String sortParam) {
        return userDaoImpl.getAllSort(operation, sortParam);
    }

    public User getUserByLogin(String login) {
        return userDaoImpl.getUserByLogin(login);
    }



}
