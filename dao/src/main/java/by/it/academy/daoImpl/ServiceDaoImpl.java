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

package by.it.academy.daoImpl;

import by.it.academy.dao.ServiceDao;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.Tariff;
import by.it.academy.pojos.User;
import by.it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by USER on 02.02.2016.
 * Класс для управления сущностью Service (услуга оператора)
 */
public class ServiceDaoImpl implements ServiceDao {

    public static Logger logger = Logger.getLogger(ServiceDaoImpl.class);

    private static ServiceDaoImpl instance;
    private ServiceDaoImpl() {
    }
    public static synchronized ServiceDaoImpl getInstance() {
        if (instance == null) {
            instance = new ServiceDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Service> getAll() {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM Service";
        Query query = session.createQuery(hql);

        List<Service> services = query.list();

        transaction.commit();
        session.flush();
        session.close();

        return services;
    }

    @Override
    public void add(Service service) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.save(service);

        transaction.commit();
        session.flush();
        session.close();
    }

    @Override
    public List<Service> userInfoServices(User user) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String login = user.getLogin();
        String hql1 ="FROM User as U WHERE U.login='" + login + "'";
        Query query1 = session.createQuery(hql1);
        List<User> users = query1.list();
        User user1 = users.get(0);
        List<Service> services = user1.getServices();
        Tariff tariff = user1.getTariff();
        String usertariff = tariff.getTariffName();

        transaction.commit();
        session.flush();
        session.close();

        return services;


    }

    @Override
    public List<Service> getAllForUser(User user) {

        long user_id = user.getId();
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hq2 = "SELECT U.services FROM User AS U WHERE U.id=" + user_id;
        Query query2 = session.createQuery(hq2);
        List<Service> services = query2.list();

        List<Integer> listOfServiceId = new ArrayList<Integer>();
        for (Service service1 : services) {
            listOfServiceId.add((int)service1.getServiceId());
        }

        String hql3 = "FROM Service";
        Query query3 = session.createQuery(hql3);
        List<Service> services3 = query3.list();

        for (int i =0; i<=(services3.size())-1; i++) {
            if (listOfServiceId.contains(i+1)) {
                services3.get(i).setUserUsed(true);
            } else {
                services3.get(i).setUserUsed(false);
            }
        }

        transaction.commit();
        session.flush();
        session.close();

        return services3;

    }


}
