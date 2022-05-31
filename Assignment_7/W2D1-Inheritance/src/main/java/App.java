import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        runApp();
        printApp();
    }

    private static void printApp() {
        System.out.println("I'm going to print");

    }

    public static void runApp() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer cus = new Customer("Yougesh", "Kumar");


        Product p1 = new Product("product1", "This is product 1");
        Product p2 = new Product("product2", "This is product 2");

        OrderLine ol1 = new OrderLine(10L,p1 );
        OrderLine ol2 = new OrderLine(11L,p2 );

        Order o1 = new Order(LocalDate.of(2010, 6, 17), cus,ol1);
        Order o2 = new Order(LocalDate.of(2010, 6, 18), cus,ol2);

        em.persist(o1);
        em.persist(o2);
//        em.persist(ol1);
//        em.persist(ol2);
        em.getTransaction().commit();
        em.close();
    }

}
