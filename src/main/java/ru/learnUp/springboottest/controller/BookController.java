package ru.learnUp.springboottest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.learnUp.springboottest.dao.entity.Book;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

    // http://localhost:8080/books/home
    @GetMapping
    public String home(Model model) {
        return "home";
    }

    // http://localhost:8080/books/catalog
    @GetMapping("/catalog")
    public String books(Model model) {

        Book book = Book.builder()
                .count(1L)
                .description("Olol")
                .name("Book")
                .price(100L)
                .imageUrl("https://origami.kosmulski.org/img/icons/book-openclipart-67633.png")
                .build();

        model.addAttribute(
                "books",
                List.of(book, book, book, book, book, book, book, book)
        );

        return "books";
    }

    @GetMapping("/book")
    public String createPage(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String createBook(@ModelAttribute Book book, Model model) {
        log.debug("{}", book);
        model.addAttribute("book", book);
        return "addBook";
    }

}
