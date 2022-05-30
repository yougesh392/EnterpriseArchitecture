package edu.mum.cs544;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    private LocalDate publishDate;

    public Book() {
    }

    public Book(String title, String ISBN, String author, double price, LocalDate publishDate) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
