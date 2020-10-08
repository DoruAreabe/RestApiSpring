package com.DoruAreabe.app.web.controller;

import com.DoruAreabe.app.entity.Book;
import com.DoruAreabe.app.service.MemoryBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    MemoryBookService memoryBookService;
    private Book book;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return memoryBookService.getAllBooks();
    }

    @PostMapping("/books")
    public String addBooks (@RequestBody Book book) {
        Long id = memoryBookService.getAllBooks().get(memoryBookService.getAllBooks().size() - 1).getId() + 1;
        book.setId(id);
        memoryBookService.getAllBooks().add(book);
        return "Success";
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> addBooks(@PathVariable long id) {
        Optional<Book> book = memoryBookService.getAllBooks().stream().filter(book1 -> book1.getId() == id).findFirst();

        if (!book.isPresent()) return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
        else {
            Book result = book.get();
            return new ResponseEntity<Book>(result, HttpStatus.OK);
        }
    }
    @PutMapping("/books")
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        Optional<Book> bookToChange = memoryBookService.getAllBooks().stream().filter(book1 -> book1.getId() == book.getId()).findFirst();
        if(bookToChange.isPresent()) {bookToChange.get().setAllFields(book);
        return new ResponseEntity<Book>(bookToChange.get(),HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable long id){
        Optional<Book> book = memoryBookService.getAllBooks().stream().filter(book1 -> book1.getId() == id).findFirst();
        if(book.isPresent()) memoryBookService.getAllBooks().remove(book.get());
        return "Success";
    }
}
