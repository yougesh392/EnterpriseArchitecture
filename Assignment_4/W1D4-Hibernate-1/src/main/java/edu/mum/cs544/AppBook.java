package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class AppBook {
    public static EntityManagerFactory emf;



    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        //Data comit on the Table
        em.getTransaction().begin();

        Book book1 = new Book("cs101", "MyISBN", "youngish", 50.00, new Date(2010 - 06 - 22));
        em.persist(book1);
        Book book2 = new Book("cs102", "MyISBN1", "youngish", 52.00, new Date(2010 - 07 - 22));
        em.persist(book2);
        Book book3 = new Book("cs103", "MyISBN2", "youngish", 55.00, new Date(2010 - 07 - 24));
        em.persist(book3);
        em.getTransaction().commit();
        em.close();
        //Data retrieve from the Table
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();

        for (Book book : bookList) {
            System.out.println("Title= " + book.getTitle() + ", ISBN= " + book.getISBN() + ", Author= " + book.getAuthor() + ", Price= " + book.getPrice() + "$");
        }
        em.getTransaction().commit();
        em.close();

        //Data retrieve and update
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> updateQuery = em.createQuery("from Book", Book.class);
        List<Book> updateBookList = updateQuery.getResultList();
        updateBookList.get(0).setTitle("cs544");
        updateBookList.get(0).setPrice(700.00);

        em.remove(updateBookList.get(1));
        em.getTransaction().commit();
        em.close();

        //After Update
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> showQuery = em.createQuery("from Book", Book.class);
        List<Book> bookListShow = showQuery.getResultList();
        for (Book book : bookListShow) {
            System.out.println("Title= " + book.getTitle() + ", ISBN= " + book.getISBN() + ", Author= " + book.getAuthor() + ", Price= " + book.getPrice() + "$");
        }
        em.getTransaction().commit();
        em.close();

    }
}
