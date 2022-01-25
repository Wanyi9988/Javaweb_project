package com.wanyi.dao.impl;

import com.wanyi.dao.BookDao;
import com.wanyi.pojo.Book;
import com.wanyi.pojo.Page;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book (name,author,price,sales,stock,img_path) values (?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public Book queryById(int id) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int deleteBookById(int id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,author,price,sales,stock,img_path as imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Page queryPage(int pageIndex, int itemsPerPage) {
        String sql1 = "select id,name,author,price,sales,stock,img_path imgPath from t_book limit ?,?";
        String sql2 = "select count(*) from t_book";
        Page page = new Page();
        page.setItemCount(((Number) queryForValue(sql2)).intValue());
        page.setPageCount(page.getItemCount() % page.getItemsPerPage() > 0 ? page.getItemCount() / page.getItemsPerPage() + 1 : page.getItemCount() / page.getItemsPerPage());
        page.setPageIndex(pageIndex);
        page.setItems(queryForList(Book.class, sql1, (page.getPageIndex() - 1) * itemsPerPage, itemsPerPage));
        return page;

    }

    @Override
    public Page searchByPrice(int pageIndex, int itemsPerPage, int min, int max) {
        String sql1 = "select * from t_book where price between ? and ? order by price limit ?,?";
        String sql2 = "select count(*) from t_book where price between ? and ?";
        Page page = new Page();
        page.setItemCount(((Number) queryForValue(sql2, min, max)).intValue());
        page.setPageCount(page.getItemCount() % page.getItemsPerPage() > 0 ? page.getItemCount() / page.getItemsPerPage() + 1 : page.getItemCount() / page.getItemsPerPage());
        page.setPageIndex(pageIndex);

        page.setItems(queryForList(Book.class, sql1, min, max, (page.getPageIndex() - 1) * itemsPerPage, itemsPerPage));
        return page;
    }
}
