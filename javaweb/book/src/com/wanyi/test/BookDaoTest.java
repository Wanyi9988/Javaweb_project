package com.wanyi.test;

import com.wanyi.dao.BookDao;
import com.wanyi.dao.impl.BookDaoImpl;
import com.wanyi.pojo.Book;
import com.wanyi.pojo.Page;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(0, "1", "1", 1, 1, 1, null));
    }

    @Test
    public void queryById() {
        System.out.println(bookDao.queryById(23));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23, "2", "2", 2, 2, 2, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    public void queryPage() {
        System.out.println(bookDao.queryPage(1, 4));
    }
}