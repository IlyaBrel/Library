package it.step.libraryit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;
    @Column(name = "date_of_publication")
    private String dataOfPublication;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;



}
