package com.wanyi.test;

import com.wanyi.dao.impl.BaseDao;
import com.wanyi.dao.impl.BookDaoImpl;
import com.wanyi.pojo.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDaoTest {
    BaseDao baseDao = new BookDaoImpl();

    @Test
    public void queryForValue() {
        String sql = "select count(*) from t_book";
        System.out.println(baseDao.queryForValue(sql));

    }

    @Test
    public void queryForList() {
        String sql = "select * from t_book where price between ? and ? limit ?,?";
        System.out.println(baseDao.queryForList(Book.class,sql,10,20,0,4));
    }
}