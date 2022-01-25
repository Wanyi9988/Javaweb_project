package com.wanyi.web;

import com.wanyi.pojo.Book;
import com.wanyi.pojo.Page;
import com.wanyi.service.BookService;
import com.wanyi.service.impl.BookServiceImpl;
import com.wanyi.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book book = WebUtils.copyParam2Bean(new Book(), request.getParameterMap());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageIndex=" + request.getParameter("pageIndex"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        bookService.deleteBookById(WebUtils.parseInt(request.getParameter("id"), 0));
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageIndex=" + request.getParameter("pageIndex"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParam2Bean(new Book(), request.getParameterMap());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageIndex=" + request.getParameter("pageIndex"));
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = bookService.queryBooks();
        request.setAttribute("books", list);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex = WebUtils.parseInt(request.getParameter("pageIndex"), 1);
        int itemsPerPage = WebUtils.parseInt(request.getParameter("itemsPerPage"), Page.Page_Size);
        Page page = bookService.queryPage(pageIndex, itemsPerPage);
        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }


}
