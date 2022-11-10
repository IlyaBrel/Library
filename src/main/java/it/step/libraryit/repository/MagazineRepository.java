package it.step.libraryit.repository;

import it.step.libraryit.model.Book;
import it.step.libraryit.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {

    @Query("SELECT p FROM Magazine p WHERE CONCAT(p.magazineName, ' ', p.dataOfPublication, ' ', p.author, ' ', p.publisher) LIKE %?1%")
    public List<Magazine> search(String keyword);
}
