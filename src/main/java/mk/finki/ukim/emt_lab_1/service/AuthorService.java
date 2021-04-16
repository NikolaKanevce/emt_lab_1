package mk.finki.ukim.emt_lab_1.service;

import mk.finki.ukim.emt_lab_1.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
    List<Author> findAll();
}
