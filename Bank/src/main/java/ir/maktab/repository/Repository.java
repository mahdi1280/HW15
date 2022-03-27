package ir.maktab.repository;

import ir.maktab.session.MySession;
import org.hibernate.Session;

public interface Repository<T> {

    default T save(T t){
        Session session = MySession.getSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        return t;
    }
}
