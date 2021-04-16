package mk.finki.ukim.emt_lab_1.web.controllers;

import mk.finki.ukim.emt_lab_1.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping
    public List<Category> findAllCategories(){
        return Arrays.asList(Category.values());
    }
}
