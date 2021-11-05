package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameBook;
    private long quantity;
    @OneToMany(mappedBy = "book")
    private Set<RentalBook> rentalBooks;

    public Book() {
    }

    public Book(long id, String nameBook, long quantity) {
        this.id = id;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Set<RentalBook> getRentalBooks() {
        return rentalBooks;
    }

    public void setRentalBooks(Set<RentalBook> rentalBooks) {
        this.rentalBooks = rentalBooks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
