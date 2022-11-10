package it.step.libraryit.repository;

import it.step.libraryit.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT p FROM Book p WHERE CONCAT(p.bookName, ' ', p.dataOfPublication, ' ', p.author, ' ', p.publisher) LIKE %?1%")
    public List<Book> search(String keyword);
}
