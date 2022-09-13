package org.acme.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String author;
    private int noOfPages;
    private int noOfBooks;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    private List<Transcation> transcations;

    public Book() {
    }

    public Book(Long id, String name, String author, int noOfPages, int noOfBooks) {
        this.id = id;
        Name = name;
        this.author = author;
        this.noOfPages = noOfPages;
        this.noOfBooks = noOfBooks;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", author='" + author + '\'' +
                ", noOfPages=" + noOfPages +
                ", noOfBooks=" + noOfBooks +
                '}';
    }
}
