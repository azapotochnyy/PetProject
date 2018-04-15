package net.goodfoodonly.dao.utils;


import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import net.goodfoodonly.dao.utils.exceptions.TransactionException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Клас призначений для налаштування з'єднанна із Базою даних. Передбачено створення лише одного екземпляру даного класу (Singleton)
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class TransactionHelper {
    private static TransactionHelper instance = new TransactionHelper();
    private MysqlConnectionPoolDataSource source = new MysqlConnectionPoolDataSource();
    private ThreadLocal<ConnectionProxy> threadLocal = new ThreadLocal<>();

    /**
     * Конструктор класу TransactionHelper() без параметрів. В тілі конструктора викликаються методи об'єкту класу MysqlConnectionPoolDataSource.class
     * setServerName(String), setDatabaseName(String), setUser(String), setPassword(String),  setUrl(String).
     */
    private TransactionHelper() {
        source.setServerName("127.0.0.1");
        source.setDatabaseName("DataBase");
        source.setUser("user1");
        source.setPassword("pass1");
        source.setUrl("jdbc:mysql://localhost:3306/classicmodels");
    }

    /**
     * @return Об'єкт класу TransactionHelper.class
     */
    public static TransactionHelper getInstance() {
        return instance;
    }

    /**
     * Метод призначений для створення об'єкту що реалізує інтерфейс java.sql.Connection та передачі його в якості параметра конструктору при створені об'єкту класу ConnectionProxy.class.
     *
     * @return Об'єкт класу ConnectionProxy.class
     * @see ConnectionProxy#ConnectionProxy(Connection)
     */
    public ConnectionProxy getConnection() {
        ConnectionProxy connectionProxy = threadLocal.get();
        if (connectionProxy == null) {
            try {
                connectionProxy = new ConnectionProxy(source.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connectionProxy;
    }

    /**
     * Метод призначений для підтвердження транзакції.
     *
     * @see ConnectionProxy#commit()
     * @see ConnectionProxy#setTransaction(boolean)
     * @see ConnectionProxy#close()
     */
    public void commit() {
        ConnectionProxy connectionProxy = threadLocal.get();
        if (connectionProxy == null) {
            throw new TransactionException();
        }
        connectionProxy.commit();
        threadLocal.remove();
        connectionProxy.setTransaction(false);
        connectionProxy.close();
    }

    /**
     * Метод призначений для початку проведення транзакції.
     *
     * @see ConnectionProxy#ConnectionProxy(Connection)
     * @see ConnectionProxy#setTransaction(boolean)
     */
    public void beginTransaction() {
        Connection connection;
        try {
            connection = source.getConnection();
            connection.setAutoCommit(false);
            ConnectionProxy connectionProxy = new ConnectionProxy(connection);
            connectionProxy.setTransaction(true);
            threadLocal.set(connectionProxy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод призначений для відкату виконання транзакції.
     *
     * @see ConnectionProxy#rollback()
     * @see ConnectionProxy#setTransaction(boolean)
     * @see ConnectionProxy#close()
     */
    public void rollback() {
        ConnectionProxy connectionProxy = threadLocal.get();
        if (connectionProxy == null) {
            throw new TransactionException();
        }
        connectionProxy.rollback();
        threadLocal.remove();
        connectionProxy.setTransaction(false);
        connectionProxy.close();
    }
}
