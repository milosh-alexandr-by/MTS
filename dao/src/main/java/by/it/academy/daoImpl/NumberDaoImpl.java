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

import by.it.academy.dao.NumberDao;
import by.it.academy.pojos.Number;
import by.it.academy.pojos.User;
import by.it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Locale;


/**
 * Created by USER on 02.02.2016.
 * Класс для управления сущностью Number (номер телефона)
 */
public class NumberDaoImpl implements NumberDao {

    public static Logger logger = Logger.getLogger(NumberDaoImpl.class);

    private static NumberDaoImpl instance;
    private NumberDaoImpl() {
    }
    public static synchronized NumberDaoImpl getInstance() {
        if (instance == null) {
            instance = new NumberDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Number> getAll() {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM Number as N";
        Query query = session.createQuery(hql);

        List<Number> numbers = query.list();

        transaction.commit();
        session.flush();
        session.close();

        return numbers;

    }

    @Override
    public void add(Number number) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.saveOrUpdate(number);

        transaction.commit();
        session.flush();
        session.close();

    }

    public Number userInfoNumber(User user) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        long user_id = user.getId();

        String hql ="FROM Number WHERE f_user_id=" + user_id;
        Query query = session.createQuery(hql);
        List<Number> numbers = query.list();
        Number number = numbers.get(0);

        transaction.commit();
        session.flush();
        session.close();

        return number;
    }

    @Override
    public int oneNumberFromBase() {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="SELECT N.number FROM Number as N WHERE N.used!=true";
        Query query = session.createQuery(hql);
        List<Integer> numbers = query.list();
        int number1 = numbers.get(0);

        transaction.commit();
        session.flush();
        session.close();

        return number1;
    }

    @Override
    public void addNumberUser(User user, int numberOfUser) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql = "FROM Number AS N WHERE N.number=" + numberOfUser;
        Query query = session.createQuery(hql);
        List<Number> results = query.list();
        Number number = results.get(0);


        number.setUsed(true);

        number.setUser(user);

        session.saveOrUpdate(number);

        transaction.commit();
        session.flush();
        session.close();

    }


}
