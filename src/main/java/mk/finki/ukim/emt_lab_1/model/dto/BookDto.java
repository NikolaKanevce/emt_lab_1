package mk.finki.ukim.emt_lab_1.model.dto;

import lombok.Data;
import mk.finki.ukim.emt_lab_1.model.Author;
import mk.finki.ukim.emt_lab_1.model.Category;

@Data
public class BookDto {
    String name;

    String category;

    Long author;

    Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, String category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
