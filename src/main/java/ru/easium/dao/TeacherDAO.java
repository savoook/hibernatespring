package ru.easium.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.easium.HibernateSessionSingleton;
import ru.easium.domain.Teacher;

import java.util.List;

@Repository
public class TeacherDAO {
    public Teacher findById(int id) {
        return HibernateSessionSingleton.getSessionFactory().openSession().get(Teacher.class, id);
    }

    public List<Teacher> findAll() {
        return HibernateSessionSingleton.getSessionFactory().openSession().createQuery("FROM Teacher").list();
    }

    public void save(Teacher teacher) {
        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(teacher);
        tx.commit();
        session.close();
    }
}
