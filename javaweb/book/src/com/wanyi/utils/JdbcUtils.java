package com.wanyi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = conns.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                conns.set(connection);
                connection.setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void commitAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }

    public static void rollbackAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
}
