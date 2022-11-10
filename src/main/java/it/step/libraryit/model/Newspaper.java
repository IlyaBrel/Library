package it.step.libraryit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "newspapers")
public class Newspaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "newspaper_name")
    private String newspaperName;

    @Column(name = "date_of_publication")
    private String dataOfPublication;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

}
