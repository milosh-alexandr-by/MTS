package by.it.academy.daoImpl;

import by.it.academy.dao.NewsDao;
import by.it.academy.pojos.News;
import by.it.academy.pojos.Tariff;
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
 * Created by USER on 11.05.2016.
 */
public class NewsDaoImpl implements NewsDao {
    public static Logger logger = Logger.getLogger(NewsDaoImpl.class);

    private static NewsDaoImpl instance;
    private NewsDaoImpl() {
    }
    public static synchronized NewsDaoImpl getInstance() {
        if (instance == null) {
            instance = new NewsDaoImpl();
        }
        return instance;
    }

    @Override
    public List<News> getAll() {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM News";
        Query query = session.createQuery(hql);

       List<News> newses = query.list();

        transaction.commit();
        session.flush();
        session.close();

      return newses;

    }

    @Override
    public List<News> getAllPagination(int firstElement) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM News";
        Query query = session.createQuery(hql);

        if( firstElement == 0) {
            firstElement = 0;
        } else if (firstElement == 1) {
            firstElement = 0;
        } else if (firstElement >= 2) {
            firstElement = (4*(firstElement - 1) + 1);
        }

        query.setFirstResult(firstElement);
        query.setMaxResults(4);

        List<News> newsesPagination = query.list();

        transaction.commit();
        session.flush();
        session.close();

        return newsesPagination;
    }

    @Override
    public List<News> getAllPaginationInverse(int firstElement) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(News.class);
        criteria.addOrder(Order.desc("newsId"));


        if( firstElement == 0) {
            firstElement = 0;
        } else if (firstElement == 1) {
            firstElement = 0;
        } else if (firstElement >= 2) {
            firstElement = (4*(firstElement - 1) + 1);
        }

        criteria.setFirstResult(firstElement);
        criteria.setMaxResults(4);

        List<News> newsesPagination = criteria.list();

        transaction.commit();
        session.flush();
        session.close();

        return newsesPagination;
    }

    @Override
    public void add(News news) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.saveOrUpdate(news);

        transaction.commit();
        session.flush();
        session.close();
    }


    @Override
    public List<Integer> infoNewsesPagination(int currentPage) {
        Locale.setDefault(Locale.US);
        HibernateUtil util = HibernateUtil.getInstance();
        Session session = util.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        String hql ="FROM News";
        Query query = session.createQuery(hql);
        List<News> newses = query.list();
        int note = newses.size();

        List<Integer> info = new ArrayList<Integer>();

        info.add(note);

        int page = 0;

        if (note%4==0) {
            page = note/4;
        } else {
            page = (note/4) + 1;
        }

        info.add(page);

        info.add(currentPage);

        transaction.commit();
        session.flush();
        session.close();

        return info;
    }
}
