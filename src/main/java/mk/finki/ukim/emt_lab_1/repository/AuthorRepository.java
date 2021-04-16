package mk.finki.ukim.emt_lab_1.repository;

import mk.finki.ukim.emt_lab_1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
