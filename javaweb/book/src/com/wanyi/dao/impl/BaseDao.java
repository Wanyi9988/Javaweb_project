package com.wanyi.dao.impl;

import com.wanyi.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        BeanHandler<T> beanHandler = new BeanHandler<T>(type);
        try {
            return queryRunner.query(connection, sql, beanHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> List queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        BeanListHandler<T> beanHandler = new BeanListHandler<T>(type);
        try {
            return queryRunner.query(connection, sql, beanHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object queryForValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        ScalarHandler scalarHandler = new ScalarHandler();
        try {
            return queryRunner.query(connection, sql, scalarHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
