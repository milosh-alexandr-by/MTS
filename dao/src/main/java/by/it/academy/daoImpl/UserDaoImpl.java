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

import by.it.academy.dao.UserDao;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.Tariff;
import by.it.academy.pojos.User;
import by.it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by USER on 02.02.2016.
 * Класс для управления сущностью User (абонент или админ)
 */
public class UserDaoImpl implements UserDao {

    public static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private static UserDaoImpl instance;
    private UserDaoImpl() {
    }
    public static synchronized UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM User";
        Query query = session.createQuery(hql);

        List<User> users = query.list();

        transaction.commit();
        session.flush();
        session.close();

        return users;
    }

    @Override
    public void add(User user) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.saveOrUpdate(user);

        transaction.commit();
        session.flush();
        session.close();
    }

    @Override
    public User getByLoginAndPassword(User user) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String logi = user.getLogin();
        String passw = user.getPassword();

        String hql ="FROM User as U WHERE U.login='"
                + logi
                + "' AND U.password='"
                + passw
                + "'";

        Query query = session.createQuery(hql);
        List<User> users = query.list();


        if (users.size()==0) {
            user.setValid(false);
        }
        else if (users.size()!=0) {
            user.setValid(true);
        }

        transaction.commit();
        session.flush();
        session.close();

        return user;

    }

    @Override
    public long getIdUser(User user) {

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
        long user_id = user1.getId();

        transaction.commit();
        session.flush();
        session.close();

        return user_id;
    }

    @Override
    public String userInfoTariff(User user) {
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
        Tariff tariff = user1.getTariff();
        String usertariff = tariff.getTariffName();

        transaction.commit();
        session.flush();
        session.close();

        return usertariff;
    }

    @Override
    public int userInfoAccount(User user) {
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
        int userAccount = user1.getAccount();

        transaction.commit();
        session.flush();
        session.close();

        return userAccount;
    }

    @Override
    public void addUserTariffById(User user,  long tariff_id) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql = "FROM Tariff AS T WHERE T.tariffId=" + tariff_id;
        Query query = session.createQuery(hql);
        List<Tariff> results = query.list();
        Tariff tariff = results.get(0);

        user.setTariff(tariff);
        session.saveOrUpdate(user);

        transaction.commit();
        session.flush();
        session.close();

    }

    @Override
    public void addUserService(User user, long serviceId) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Service service = (Service) session.get(Service.class, serviceId);

        String login = user.getLogin();

        String hql ="FROM User as U WHERE U.login='" + login + "'";

        Query query = session.createQuery(hql);
        List<User> users = query.list();
        User user1 = users.get(0);
        long uId = user1.getId();
        User user2 = (User) session.get(User.class, uId);

        user2.getServices().add(service);

        session.save(user2);

        transaction.commit();
        session.flush();
        session.close();

    }

    @Override
    public void changeUserAccount(User user, int changeAccount) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        int currentAccount = user.getAccount();
        int nextAccount = currentAccount + changeAccount;
        user.setAccount(nextAccount);

        session.saveOrUpdate(user);

        transaction.commit();
        session.flush();
        session.close();

    }

    @Override
    public void deleteUserService(User user, long serviceId) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql = "FROM Service AS S WHERE S.serviceId=" + serviceId;
        Query query = session.createQuery(hql);
        List<Service> results = query.list();
        Service service = results.get(0);

        long user_id = user.getId();
        String hql1 = "FROM User AS u WHERE u.id=" + user_id;
        Query query1 = session.createQuery(hql1);
        List<User> results1 = query1.list();
        User user1 = results1.get(0);

        user1.getServices().remove(service);

        session.saveOrUpdate(user1);

        transaction.commit();
        session.flush();
        session.close();

    }

    @Override
    public User getUserByLogin(String login) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM User as U WHERE U.login='" + login +  "'";

        Query query = session.createQuery(hql);
        List<User> users = query.list();
        User user = new User();
        user = users.get(0);

        transaction.commit();
        session.flush();
        session.close();

        return user;
    }

    @Override
    public List<User> getAllSort(String operation, String sortParam) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List<User> results = new ArrayList<User>();

        if (sortParam.equals("big")) {
            Criteria criteria = session.createCriteria(User.class);
            criteria.addOrder(Order.desc(operation));
            results = criteria.list();
        } else if (sortParam.equals("small")) {
            Criteria criteria = session.createCriteria(User.class);
            criteria.addOrder(Order.asc(operation));
            results = criteria.list();
        }

        transaction.commit();
        session.flush();
        session.close();

        return results;
    }


}
