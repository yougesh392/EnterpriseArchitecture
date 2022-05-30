package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class AppBook {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        save();
        list(getAllBook());

        System.out.println("---------------------------- After Update ------------------------------");
        update();
        list(getAllBook());

        System.out.println("---------------------------- After Delete ------------------------------");
        delete();
        list(getAllBook());
    }

    public static void save(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book b1 = new Book( "Book 1", "Book 1 ISBN", "Book 1 Author", 1, LocalDate.of(2011, 10, 10));
        em.persist(b1);
        Book b2 = new Book( "Book 2", "Book 2 ISBN", "Book 2 Author", 2, LocalDate.of(2012, 10, 10));
        em.persist(b2);
        Book b3 = new Book( "Book 3", "Book 3 ISBN", "Book 3 Author", 3, LocalDate.of(2013, 10, 10));
        em.persist(b3);

        em.getTransaction().commit();
        em.close();
    }

    public static void list(List<Book> bookList){
        bookList.forEach(System.out::println);
    }

    public static List<Book> getAllBook(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("FROM Book", Book.class);
        List<Book> bookList = query.getResultList();


        em.getTransaction().commit();
        em.close();
        return bookList;
    }

    public static void update(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book b = em.find(Book.class, 1);
        b.setTitle("Title Updated");
        b.setPrice(200);

        em.merge(b);
        em.getTransaction().commit();
        em.close();
    }

    public static void delete(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book b = em.find(Book.class, 2);

        em.remove(em.merge(b));

        em.getTransaction().commit();
        em.close();
    }
}
