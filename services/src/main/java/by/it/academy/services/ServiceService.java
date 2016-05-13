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

import by.it.academy.daoImpl.ServiceDaoImpl;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.User;

import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public class ServiceService {

    private static ServiceService instance;
    private ServiceService() {
    }
    public static synchronized ServiceService getInstance() {
        if (instance == null) {
            instance = new ServiceService();
        }
        return instance;
    }

    ServiceDaoImpl serviceDaoImpl = ServiceDaoImpl.getInstance();

    public List<Service> getAll() {
        return serviceDaoImpl.getAll();
    }

    public void add(Service service) {
        serviceDaoImpl.add(service);
    }

    public List<Service> userInfoServices(User user) {
        return serviceDaoImpl.userInfoServices(user);
    }

    public List<Service> getAllForUser(User user) {
        return serviceDaoImpl.getAllForUser(user);
    }



}
