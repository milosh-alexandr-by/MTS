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

import by.it.academy.daoImpl.NumberDaoImpl;
import by.it.academy.pojos.*;
import by.it.academy.pojos.Number;

import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public class NumberService {

    private static NumberService instance;
    private NumberService() {
    }
    public static synchronized NumberService getInstance() {
        if (instance == null) {
            instance = new NumberService();
        }
        return instance;
    }

    NumberDaoImpl numberDaoImpl = NumberDaoImpl.getInstance();


    public List<Number> getAll() {
        return numberDaoImpl.getAll();
    }

    public void add(Number number) {
        numberDaoImpl.add(number);
    }

    public Number userInfoNumber(User user) {
        return numberDaoImpl.userInfoNumber(user);
    }

    public int oneNumberFromBase() {
        return numberDaoImpl.oneNumberFromBase();
    }

    public void addNumberUser(User user, int numberOfUser) {
        numberDaoImpl.addNumberUser(user, numberOfUser);
    }



}
