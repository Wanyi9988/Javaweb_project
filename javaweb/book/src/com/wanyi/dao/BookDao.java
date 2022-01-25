package com.wanyi.dao;

import com.wanyi.pojo.Book;
import com.wanyi.pojo.Page;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public Book queryById(int id);

    public int updateBook(Book book);

    public int deleteBookById(int id);

    public List<Book> queryBooks();

    public Page queryPage(int pageIndex, int itemsPerPage);

    public Page searchByPrice(int pageIndex, int itemsPerPage, int min, int max);
}
