package ir.maktab.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySession {

    private static class Sessions{
        public final static SessionFactory sessionFactory;
        static {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
    }

    public static Session getSession(){
        return Sessions.sessionFactory.openSession();
    }
}
