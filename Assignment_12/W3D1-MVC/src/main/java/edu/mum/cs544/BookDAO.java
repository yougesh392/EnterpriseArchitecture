package edu.mum.cs544;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDAO implements IBookDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAll() {
        return em.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public void add(Book b) {
        em.persist(b);
    }

    @Override
    public Book get(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public void update(Book b) {
        em.merge(b);
    }

    @Override
    public void delete(int id) {
        Book b = em.getReference(Book.class, id);
        em.remove(b);
    }
}
