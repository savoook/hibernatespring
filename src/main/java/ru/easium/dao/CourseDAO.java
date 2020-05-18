package ru.easium.dao;

import ru.easium.domain.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDAO {
    @PersistenceContext
    private EntityManager em;

    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    public List<Course> findAll() {
        return em.createQuery("FROM Course").getResultList();
    }

    @Transactional
    public void save(Course course) {
        em.persist(course);
//        throw new RuntimeException("Непредвиденная ошибка");
    }
}

