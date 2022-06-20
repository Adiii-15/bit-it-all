package com.experiment.library.book;

import javax.persistence.*;
import java.time.LocalDate;

// Class represents a book in the library
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String name;
    private String summary;

    private String genre;
    private LocalDate publication;

    // Default Constructor
    public Book() {
    }

    public Book(Long id,
                String name,
                String summary,
                String genre,
                LocalDate publication) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.genre = genre;
        this.publication = publication;
    }

    // Constructor auto generates the book ID from the DataBase.
    public Book(String name,
                String summary,
                String genre,
                LocalDate publication) {
        this.name = name;
        this.summary = summary;
        this.genre = genre;
        this.publication = publication;
    }

    //  Getters and Setters
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", genre='" + genre + '\'' +
                ", publication=" + publication +
                '}';
    }
}
