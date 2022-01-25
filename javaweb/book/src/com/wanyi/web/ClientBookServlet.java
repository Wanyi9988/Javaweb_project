package com.wanyi.web;

import com.wanyi.pojo.Page;
import com.wanyi.service.BookService;
import com.wanyi.service.impl.BookServiceImpl;
import com.wanyi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BookServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex = WebUtils.parseInt(request.getParameter("pageIndex"), 1);
        int itemsPerPage = WebUtils.parseInt(request.getParameter("itemsPerPage"), Page.Page_Size);
        Page page = bookService.queryPage(pageIndex, itemsPerPage);
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void searchByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex = WebUtils.parseInt(request.getParameter("pageIndex"), 1);
        int itemsPerPage = WebUtils.parseInt(request.getParameter("itemsPerPage"), Page.Page_Size);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), 9999);
        Page page = bookService.searchByPrice(pageIndex,itemsPerPage,min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=searchByPrice");
        if(request.getParameter("min")!=null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max")!=null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
