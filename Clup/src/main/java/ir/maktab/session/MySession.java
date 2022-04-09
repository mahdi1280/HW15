package ir.maktab.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySession {

    private static class SessionsHolder {
        private static final SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getSessionFactory(){
        return SessionsHolder.sessionFactory.openSession();
    }
}
