package com.wanyi.filter;

import com.wanyi.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException(e);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
