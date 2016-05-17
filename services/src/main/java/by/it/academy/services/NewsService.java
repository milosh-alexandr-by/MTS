package by.it.academy.services;

import by.it.academy.daoImpl.NewsDaoImpl;
import by.it.academy.pojos.*;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Locale;

/**
 * Created by USER on 11.05.2016.
 */
public class NewsService {

    private static NewsService instance;
    private NewsService() {
    }
    public static synchronized NewsService getInstance() {
        if (instance == null) {
            instance = new NewsService();
        }
        return instance;
    }

    NewsDaoImpl newsDaoImpl = NewsDaoImpl.getInstance();

    public List<News> getAll() {
        return newsDaoImpl.getAll();
    }

    public void add(News news) {
        newsDaoImpl.add(news); }

    public List<Integer> infoNewsesPagination(int currentPage) {
        return newsDaoImpl.infoNewsesPagination(currentPage);
    }

    public List<News> getAllPagination(int firstElement) {
        return newsDaoImpl.getAllPagination(firstElement);
    }

    public List<News> getAllPaginationInverse(int firstElement) {
        return newsDaoImpl.getAllPaginationInverse(firstElement);
    }

}
