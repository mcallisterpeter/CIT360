import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TipsDAO {
    public void addTipInfo (String myDate, String orderId, String sale, String tip) {
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            String myQuery = "select max(id) from tips";
            Query query = session.createQuery(myQuery);
            List list = query.list();
            System.out.println(list.get(0));

            tips logTip = new tips();
            logTip.setId((int)list.get(0) + 1);
            logTip.setMyDate(myDate);
            logTip.setOrderId(orderId);
            logTip.setSale(sale);
            logTip.setTip(tip);
            session.save(logTip);
            transaction.commit();
            sessionFactory.close();
            System.out.println("\n\n Tips Added \n");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
        }
    }
}
