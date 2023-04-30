package ru.mpei.hw2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.hw2.domain.Mark;

@Transactional
@Repository
public class MarkRepositoryJpa implements MarkRepository{
    @PersistenceContext
    private final EntityManager em;
    public MarkRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Mark save(Mark mark) {
        if (mark.getId() <= 0) {
            em.persist(mark);

            return mark;
        } else {
            return em.merge(mark);
        }
    }
}
