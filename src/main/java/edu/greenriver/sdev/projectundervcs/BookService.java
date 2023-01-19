package edu.greenriver.sdev.projectundervcs;

import edu.greenriver.sdev.projectundervcs.repositories.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * This class will have our business logic.
 * @author Keny Dutton-Gillespie
 *  @version 1.0
 */
@Service
public class BookService
{
    private List<Book> booksList = List.of(
            new Book( "Sword of Destiny" , "Andrzej Sapkowski", 384),
            new Book( "Lord d'Arcy Investigates", "Randal Garrett", 229),
            new Book( "Powers of the Subconscious Mind" , "Joseph Murphy", 384),
            new Book("The Very Hungry Catapillar" , "Eric Carle", 32),
            new Book( "A Man Called Ove", "Fredrick Backman", 368),
            new Book( "Crash", "Sam Smith", 300)
    );

    public List<Book> getEveryBook()
    {
        return booksList;
    }

    public Book random()
    {
        Random random = new Random();
        int randomIndex = random.nextInt(booksList.size());
        return booksList.get(randomIndex);
    }


    public Book byName(String name)
    {
        Optional<Book> found = booksList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(name))
                .findFirst();

        if(found.isPresent())
        {
            return found.get();
        }
        return null;
    }

    public List<Book> byPages(int minPages)
    {
        List<Book> found = booksList.stream()
                .filter(book -> book.getPages() >= minPages)
                .toList();

        return found;
    }

}
