package com.wanyi.test;

import com.wanyi.dao.BookDao;
import com.wanyi.dao.impl.BookDaoImpl;
import com.wanyi.pojo.Page;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void searchByPrice() {
        Page page = bookDao.searchByPrice(0, 4, 10, 20);
        System.out.println(page.getItems());
        System.out.println(page.getItemCount());
    }
}