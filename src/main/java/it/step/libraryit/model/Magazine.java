package it.step.libraryit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "magazines")
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "magazines_name")
    private String magazineName;
    @Column(name = "date_of_publication")
    private String dataOfPublication;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;


}
