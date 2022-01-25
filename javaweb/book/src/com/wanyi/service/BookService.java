package com.wanyi.service;

import com.wanyi.pojo.Book;
import com.wanyi.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(int id);

    public void updateBook(Book book);

    public Book queryBookById(int id);

    public List<Book> queryBooks();

    public Page queryPage(int pageIndex, int itemsPerPage);

    public Page searchByPrice(int pageIndex, int itemsPerPage, int min, int max);

}
