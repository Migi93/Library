package com.api.library.infrastructure.inputport;

import com.api.library.domain.model.Books;

import java.util.List;

public interface BooksInputPort {

    void insertBook(Books books);

    Books getBook(int bookId);

    List<Books> listBooks();

    void deleteBook(int bookId);

    void updateBook(Books books);
}
