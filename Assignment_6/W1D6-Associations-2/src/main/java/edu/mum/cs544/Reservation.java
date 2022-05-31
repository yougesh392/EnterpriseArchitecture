package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;

    @ManyToOne
    private Book book;

    public Reservation() {
    }

    public Reservation(LocalDate date) {
        this.date = date;
    }

    public Reservation(LocalDate date, Book book) {
        this.date = date;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", book=" + book +
                '}';
    }
}
