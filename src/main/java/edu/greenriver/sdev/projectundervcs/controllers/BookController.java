package edu.greenriver.sdev.projectundervcs.controllers;

import edu.greenriver.sdev.projectundervcs.BookService;
import edu.greenriver.sdev.projectundervcs.repositories.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class BookController
{

    private BookService service;

    public BookController(BookService service)
    {
        this.service = service;
    }

    @GetMapping("books")
    public List<Book> getAllBooks()
    {
        return service.getEveryBook();
    }

    @GetMapping("books/random")
    public Book getRandomBook()
    {
        return service.random();
    }

    @GetMapping("books/by-name/{bookName}")
    public Book getBookByName(@PathVariable String bookName)
    {
        return service.byName(bookName);
    }

    //write a route that provides a number of pages and returns
    //a book with that many pages
    @GetMapping("books/by-pages/{pageTotal}")
    public List<Book> getLongerBooksByPages(@PathVariable int pageTotal)
    {
        return service.byPages(pageTotal);
    }
}
