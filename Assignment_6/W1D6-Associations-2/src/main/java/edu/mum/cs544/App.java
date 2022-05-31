package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        exeA();
        printExeA();

        exeB();
        printExeB();

        exeC();
        printExeC();

        exeD();
        printExeD();

        exeE();
        printExeE();

        exeF();
        printExeF();

    }

    public static void exeA(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department dp = new Department("Human Resource");
        Employee emp1 = new Employee("Barry Allan", dp);
        Employee emp2 = new Employee("Oliver Torres", dp);

        em.persist(emp1);
        em.persist(emp2);

        em.getTransaction().commit();
        em.close();
    }
    public static void printExeA(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Employee> query = em.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
    public static void exeB(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Publisher publisher = new Publisher("Publisher 1");

        Book b1 = new Book("123", "JAVA", "Tyler", publisher);

        em.persist(b1);

        em.getTransaction().commit();
        em.close();
    }
    public static void printExeB(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("FROM Book", Book.class);
        List<Book> bookList = query.getResultList();

        bookList.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
    public static void exeC(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Course c1 = new Course("333", "EA");
        Course c2 = new Course("444", "ALGO");


        Student s1 = new Student(11L, "John", "Smith");
        s1.setCourses(new ArrayList<>(){{add(c1); add(c2);}});
        Student s2 = new Student(22L, "Chris", "Colorado");
        s2.setCourses(new ArrayList<>(){{add(c2);}});

        c1.setStudents(new ArrayList<>(){{add(s1);}});
        c2.setStudents(new ArrayList<>(){{add(s1); add(s2);}});

        em.persist(c1);
        em.persist(c2);
        em.persist(s1);
        em.persist(s2);



        em.getTransaction().commit();
        em.close();

    }
    public static void printExeC(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Student> query = em.createQuery("FROM Student", Student.class);

        List<Student> students = query.getResultList();

        students.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
    public static void exeD(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Reservation r1 = new Reservation(LocalDate.now());
        Reservation r2 = new Reservation(LocalDate.of(2022, 10, 10));

        Customer c1 = new Customer("David Chat", List.of(r1, r2));
        em.persist(r1);
        em.persist(r2);
        em.persist(c1);

        em.getTransaction().commit();
        em.close();
    }
    public static void printExeD(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery query = em.createQuery("FROM Customer", Customer.class);
        List<Customer> customers = query.getResultList();

        customers.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
    public static void exeE(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Reservation r1 = new Reservation(LocalDate.now(), em.find(Book.class, "123"));
        Reservation r2 = new Reservation(LocalDate.of(2022, 10, 10), em.find(Book.class, "123"));

        Customer c1 = new Customer("Max Hunter", List.of(r1, r2));
        em.persist(r1);
        em.persist(r2);
        em.persist(c1);


        em.getTransaction().commit();
        em.close();
    }
    public static void printExeE(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery query = em.createQuery("FROM Reservation", Reservation.class);
        List<Reservation> reservations = query.getResultList();

        reservations.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
    public static void exeF(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department dp = new Department("Human Resource");
        Office office = new Office("Verril Hall");
        Employee emp1 = new Employee("Lucas Jesus", dp, office);
        em.persist(office);
        em.persist(emp1);

        em.getTransaction().commit();
        em.close();
    }
    public static void printExeF(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Employee> query = em.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
