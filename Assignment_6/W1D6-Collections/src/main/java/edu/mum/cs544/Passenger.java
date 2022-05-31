package edu.mum.cs544;

import javax.persistence.*;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Flight> flights;

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger(String name, List<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
