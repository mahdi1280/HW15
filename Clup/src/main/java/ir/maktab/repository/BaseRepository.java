package ir.maktab.repository;

import ir.maktab.session.MySession;
import org.hibernate.Session;

public interface BaseRepository<T> {

    default void save(T t){
        Session sessionFactory = MySession.getSessionFactory();
        sessionFactory.beginTransaction();
        sessionFactory.save(t);
        sessionFactory.getTransaction().commit();
    }

    default void update(T t){
        Session sessionFactory = MySession.getSessionFactory();
        sessionFactory.beginTransaction();
        sessionFactory.update(t);
        sessionFactory.getTransaction().commit();
    }

    default void delete(T t){
        Session sessionFactory = MySession.getSessionFactory();
        sessionFactory.beginTransaction();
        sessionFactory.delete(t);
        sessionFactory.getTransaction().commit();
    }

    default T findById(Class<T> clazz,Long id){
        Session sessionFactory = MySession.getSessionFactory();
        sessionFactory.beginTransaction();
        T t = sessionFactory.get(clazz, id);
        sessionFactory.getTransaction().commit();
        return t;
    }

    default T findByName(Class<T> clazz,String name){
        Session sessionFactory = MySession.getSessionFactory();
        sessionFactory.beginTransaction();
        T t = sessionFactory.get(clazz, name);
        sessionFactory.getTransaction().commit();
        return t;
    }


}
