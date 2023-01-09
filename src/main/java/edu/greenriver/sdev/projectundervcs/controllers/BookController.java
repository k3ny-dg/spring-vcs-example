package edu.greenriver.sdev.projectundervcs.controllers;

import edu.greenriver.sdev.projectundervcs.repositories.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController
{
    private List<Book> booksList = List.of(
            new Book( "Sword of Destiny" , "Andrzej Sapkowski", 384),
            new Book( "Lord d'Arcy Investigates", "Randal Garrett", 229),
            new Book( "Powers of the Subconcious Mind" , "Joseph Murphy", 384),
            new Book("The Very Hungry Catapillar" , "Eric Carle", 32),
            new Book( "A Man Called Ove", "Fredrick Backman", 368)
    );
@GetMapping("books")
    public List<Book> getAllBooks()
    {
        return booksList;
    }


}
