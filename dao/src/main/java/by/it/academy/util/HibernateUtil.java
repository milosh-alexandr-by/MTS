package by.it.academy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by USER on 28.04.2016.
 */
public class HibernateUtil {
    private static HibernateUtil instance;
    SessionFactory sessionFactory = null;

    private final ThreadLocal sessions = new ThreadLocal();

    private HibernateUtil() {
        try {
            Configuration configuration = new AnnotationConfiguration();
            configuration.setNamingStrategy(new CustomNamingStrategy());
            sessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static synchronized HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
