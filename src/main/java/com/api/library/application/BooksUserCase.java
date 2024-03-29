package com.api.library.application;

import com.api.library.application.Enum.Amount;
import com.api.library.application.exceptions.ObjectNotFoundException;
import com.api.library.application.exceptions.ObjectAlreadyExistsException;
import com.api.library.application.utils.ValidationsUtils;
import com.api.library.domain.model.Books;
import com.api.library.domain.model.Editorials;
import com.api.library.infrastructure.inputport.BooksInputPort;
import com.api.library.infrastructure.outputport.BooksRepository;
import com.api.library.infrastructure.outputport.EditorialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksUserCase implements BooksInputPort {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    EditorialsRepository editorialsRepository;
    @Autowired
    ValidationsUtils validationsUtils;

    @Override
    public void insertBook(Books books) {
        existIsbn(books.getIsbn());
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_100.getValue(), books.getTitle().length(), "title");
        validationsUtils.validateNotIsEmpty(books.getTitle(), "title");
        existEditorial(books.getEditorial());
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_17.getValue(), books.getIsbn().length(), "isbn");
        validationsUtils.validateNotIsEmpty(books.getIsbn(), "isbn");
        booksRepository.insertBook(books);
    }

    @Override
    public Books getBook(int bookId) {
        existBook(bookId);
        return booksRepository.getBook(bookId);
    }

    @Override
    public List<Books> listBooks() {
        return booksRepository.getBooks();
    }

    @Override
    public void deleteBook(int bookId) {
        existBook(bookId);
        booksRepository.deleteBook(bookId);
    }

    @Override
    public void updateBook(Books books) {
        existBook(books.getBookId());
        existEditorial(books.getEditorial());
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_100.getValue(), books.getTitle().length(), "title");
        validationsUtils.validateNotIsEmpty(books.getTitle(), "title");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_17.getValue(), books.getIsbn().length(), "isbn");
        validationsUtils.validateNotIsEmpty(books.getIsbn(), "isbn");
        booksRepository.updateBook(books);
    }

    private void existBook(int bookId) {
        if (booksRepository.existBook(bookId) < 1) {
            throw new ObjectNotFoundException("book", HttpStatus.NOT_FOUND);
        }
    }

    private void existEditorial(Editorials editorials) {
        if (editorialsRepository.notExistEditorial(editorials.getEditorialId()) < 1) {
            throw new ObjectNotFoundException("editorial", HttpStatus.NOT_FOUND);
        }
    }

    private void existIsbn(String isbn) {
        if (booksRepository.existIsbn(isbn) > 0) {
            throw new ObjectAlreadyExistsException("isbn", HttpStatus.CONFLICT);
        }
    }
}
