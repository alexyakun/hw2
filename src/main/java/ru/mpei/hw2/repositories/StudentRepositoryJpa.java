package ru.mpei.hw2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.hw2.domain.Student;

import java.util.List;

@Transactional
@Repository
public class StudentRepositoryJpa implements StudentRepository{
    @PersistenceContext
    private final EntityManager em;
    public StudentRepositoryJpa(EntityManager em) {
        this.em = em;
    }
    @Override
    public Student save(Student student){
        if (student.getId() <= 0) {
            em.persist(student);
            return student;
        } else {
            return em.merge(student);
        }

    }

    @Override
    public List<Student> findByGroup(String gname) {
        TypedQuery<Student> query = em.createQuery("select s from Student s  join fetch s.marks where s.groupName=:gname", Student.class);
        query.setParameter("gname",gname);
        return query.getResultList();
    }
}
