package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppSimpsons {
    public static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("simpsons");
        //get First name of the students
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> studentsQuery = em.createQuery("from Students", Students.class);
        List<Students> stdList = studentsQuery.getResultList();
        for (Students std : stdList) {
            System.out.println(std.getName());
        }
        em.getTransaction().commit();
        em.close();

        // add a student
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Students std1 = new Students(1,"inaam", "inam@inaam.com", "613837");
        em.persist(std1);
        em.getTransaction().commit();
        em.close();
//        retrive all the studetns
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> studentsQueryAgain = em.createQuery("from Students", Students.class);
        List<Students> stdList1 = studentsQueryAgain.getResultList();
        for (Students std : stdList1) {
            System.out.println(std.getName());
        }
        em.getTransaction().commit();
        em.close();

    }
}
