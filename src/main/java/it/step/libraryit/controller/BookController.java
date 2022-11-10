package it.step.libraryit.controller;

import it.step.libraryit.model.Book;
import it.step.libraryit.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String findAll(Model model, @Param("keyword") String keyword) {

        List<Book> books = bookService.findAll(keyword);
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);
        return "book-list";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book, Model model) {
        model.addAttribute("book", book);
        return "book-create";
    }

    @PostMapping("/book-create")
    public String createBook(Book book) {
        System.out.println("PR");
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateBook(Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

}
