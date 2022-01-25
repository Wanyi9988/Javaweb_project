package com.wanyi.service.impl;

import com.wanyi.dao.BookDao;
import com.wanyi.dao.impl.BookDaoImpl;
import com.wanyi.pojo.Book;
import com.wanyi.pojo.Page;
import com.wanyi.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page queryPage(int pageIndex, int itemsPerPage) {
        return bookDao.queryPage(pageIndex, itemsPerPage);
    }

    public Page searchByPrice(int pageIndex, int itemsPerPage, int min, int max) {
        return bookDao.searchByPrice(pageIndex, itemsPerPage, min, max);
    }
}
