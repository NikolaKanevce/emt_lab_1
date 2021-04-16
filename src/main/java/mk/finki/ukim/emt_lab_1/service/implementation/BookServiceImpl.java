package mk.finki.ukim.emt_lab_1.service.implementation;

import mk.finki.ukim.emt_lab_1.model.Author;
import mk.finki.ukim.emt_lab_1.model.Book;
import mk.finki.ukim.emt_lab_1.model.Category;
import mk.finki.ukim.emt_lab_1.model.dto.BookDto;
import mk.finki.ukim.emt_lab_1.model.exceptions.AuthorDoesNotExistException;
import mk.finki.ukim.emt_lab_1.model.exceptions.BookDoesNotExistException;
import mk.finki.ukim.emt_lab_1.repository.AuthorRepository;
import mk.finki.ukim.emt_lab_1.repository.BookRepository;
import mk.finki.ukim.emt_lab_1.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Category category = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorDoesNotExistException::new);
        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);
        Category category = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorDoesNotExistException::new);
        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
