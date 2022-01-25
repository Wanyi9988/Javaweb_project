package com.wanyi.test;

import com.wanyi.pojo.Book;
import com.wanyi.service.BookService;
import com.wanyi.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(0, "1", "1", 1, 1, 1, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24, "2", "2", 1, 1, 1, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookService.queryBooks());
    }

    @Test
    public void queryPage(){
        System.out.println(bookService.queryPage(1,4));
    }
}