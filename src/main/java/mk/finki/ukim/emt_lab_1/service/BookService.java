package mk.finki.ukim.emt_lab_1.service;

import mk.finki.ukim.emt_lab_1.model.Book;
import mk.finki.ukim.emt_lab_1.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Page<Book> findAll(Pageable pageable);
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> update(Long id, BookDto bookDto);
    void markAsTaken(Long id);
    void deleteById(Long id);
}
