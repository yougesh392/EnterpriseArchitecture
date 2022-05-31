package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Owner owner1 = new Owner("John Doe", "Fairfield");

        Car car1 = new Car("BMW", "SDA231", 30221.00, owner1);
        em.persist(car1);
        Car car2 = new Car("Mercedes", "HOO100", 4088.00, owner1);
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            String res = """
                    brand = %s, year = %s, price = %f | Owner name: %s, address: %s
                    """.formatted(car.getBrand(), car.getYear(), car.getPrice(), car.getOwners().getName(), car.getOwners().getAddress());
            System.out.println(res);
        }
        em.getTransaction().commit();
        em.close();

    }
}
