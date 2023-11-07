package www.week2.week02_lab_phanhoaian_20012781.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class BaseRepository<T> {
    protected SessionFactory sessionFactory;

    public BaseRepository() {
        sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }

    public List<T> getAll(Class<T> t) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + t.getName(), t).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean update(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    //delete
    public boolean delete(long id, Class<T> t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            T objectToDelete = session.get(t, id);
            if (objectToDelete != null) {
                session.remove(objectToDelete);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
