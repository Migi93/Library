package com.api.library.infrastructure.inputadapter;

import com.api.library.domain.model.Books;
import com.api.library.infrastructure.inputport.BooksInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksAPI {
    @Autowired
    BooksInputPort booksInputPort;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Integer> addBook(@RequestBody Books books) {
        booksInputPort.insertBook(books);
        return Map.of("id", books.getBookId());
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Books> getAllBooks() {
        return booksInputPort.listBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Books getBook(@PathVariable("id") int bookId) {
        return booksInputPort.getBook(bookId);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@RequestParam("id") int bookId) {
        this.booksInputPort.deleteBook(bookId);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Books books) {
        this.booksInputPort.updateBook(books);
    }
}
