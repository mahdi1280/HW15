package ir.maktab.repository;

import ir.maktab.model.Borrow;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class BorrowRepository implements BaseRepository<Borrow> {

    public List<Borrow> getBorrowLate(){
        Session sessionFactory = MySession.getSessionFactory();
        return sessionFactory.createQuery("select b from Borrow b where b.rejected=false and b.date<:date", Borrow.class)
                .setParameter("date", LocalDateTime.now().minusDays(7))
                .getResultList();
    }

    public List<Borrow> getBorrows(){
        Session sessionFactory = MySession.getSessionFactory();
        return sessionFactory.createQuery("select b from Borrow b where b.rejected=false", Borrow.class)
                .getResultList();
    }
}
