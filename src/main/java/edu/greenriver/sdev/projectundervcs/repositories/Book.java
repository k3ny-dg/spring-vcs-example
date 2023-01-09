package edu.greenriver.sdev.projectundervcs.repositories;

import lombok.*;

@Data
@NoArgsConstructor
@Builder

public class Book
{
    private String author;
    private String title;
    private int pages;

    public Book(String author, String title, int pages)
    {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }


    public static BookBuilder builder()
    {
        return new BookBuilder();
    }

    protected boolean canEqual(final Object other)
    {
        return other instanceof Book;
    }

    public static class BookBuilder
    {
        private String author;
        private String title;
        private int pages;

        BookBuilder()
        {
        }

        public BookBuilder author(String author)
        {
            this.author = author;
            return this;
        }

        public BookBuilder title(String title)
        {
            this.title = title;
            return this;
        }

        public BookBuilder pages(int pages)
        {
            this.pages = pages;
            return this;
        }

        public Book build()
        {
            return new Book(author, title, pages);
        }

        public String toString()
        {
            return "Book.BookBuilder(author=" + this.author + ", title=" + this.title + ", pages=" + this.pages + ")";
        }
    }
}
