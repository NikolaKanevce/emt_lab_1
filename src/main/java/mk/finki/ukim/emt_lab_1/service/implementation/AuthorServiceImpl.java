package mk.finki.ukim.emt_lab_1.service.implementation;

import mk.finki.ukim.emt_lab_1.model.Author;
import mk.finki.ukim.emt_lab_1.repository.AuthorRepository;
import mk.finki.ukim.emt_lab_1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
