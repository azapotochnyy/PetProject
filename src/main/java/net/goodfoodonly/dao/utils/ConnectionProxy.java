package net.goodfoodonly.dao.utils;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Клас proxi для об'єктів реалізації інтерфейсу java.sql.Connection, java.sql.Statement, java.sql.PreparedStatement
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ConnectionProxy implements Closeable {
    private Connection connection;
    private boolean isTransaction;

    /**
     * Полю connection класу ConnectionProxy.class присвоюється значення отримане в параметрі метода.
     *
     * @param connection об'єкт що реалізує інтерфейс java.sql.Connection
     */
    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return об'єкт, що реалізує інтерфейс java.sql.Statement
     * @throws SQLException виключення, що надає інформацію про помилку доступу до бази даних або інші
     */
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    /**
     * @param selectUser текст запиту до БД.
     * @return об'єкт, що реалізує інтерфейс java.sql.PreparedStatement.
     * @throws SQLException виключення, що надає інформацію про помилку доступу до бази даних або інші
     */
    public PreparedStatement createPreparedStatement(String selectUser) throws SQLException {
        return connection.prepareStatement(selectUser);
    }

    /**
     * Метод виконання транзакції.
     */
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод закриття proxi з'єднання.
     */
    @Override
    public void close() {
        if (!isTransaction) try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод відкату виконання транзакції.
     */
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param transaction true - встановлюється коли об'єкт класу ConnectionProxy.class бере участь у проведені транзакції або false транзакцію завершив або не бере участі у проведені транзакції.
     */
    public void setTransaction(boolean transaction) {
        isTransaction = transaction;
    }
}



