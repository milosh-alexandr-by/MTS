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

import by.it.academy.dao.TariffDao;
import by.it.academy.pojos.Tariff;
import by.it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Locale;


/**
 * Created by USER on 02.02.2016.
 * Класс для управления сущностью Tariff (тариф)
 */
public class TariffDaoImpl implements TariffDao {

    public static Logger logger = Logger.getLogger(TariffDaoImpl.class);

    private static TariffDaoImpl instance;
    private TariffDaoImpl() {
    }
    public static synchronized TariffDaoImpl getInstance() {
        if (instance == null) {
            instance = new TariffDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Tariff> getAll() {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM Tariff";
        Query query = session.createQuery(hql);

        List<Tariff> tariffs = query.list();

        transaction.commit();
        session.flush();
        session.close();

        return tariffs;

    }

    @Override
    public void add(Tariff tariff) {

        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.save(tariff);

        transaction.commit();
        session.flush();
        session.close();

    }


}
