package com.codegym.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "rentalbook")
public class RentalBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long codeRenta;
    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public RentalBook() {
    }

    public RentalBook(long codeRenta, Book book) {
        this.codeRenta = codeRenta;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodeRenta() {
        return codeRenta;
    }

    public void setCodeRenta(long codeRenta) {
        this.codeRenta = codeRenta;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
