package it.step.libraryit.repository;

import it.step.libraryit.model.Book;
import it.step.libraryit.model.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {

    @Query("SELECT p FROM Newspaper p WHERE CONCAT(p.newspaperName, ' ', p.dataOfPublication, ' ', p.author, ' ', p.publisher) LIKE %?1%")
    public List<Newspaper> search(String keyword);
}
