package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    private String ISBN;
    private String title;
    private String author;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Book_Publisher")
    private Publisher publisher;

    public Book() {
    }

    public Book(String ISBN, String title, String author, Publisher publisher) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
