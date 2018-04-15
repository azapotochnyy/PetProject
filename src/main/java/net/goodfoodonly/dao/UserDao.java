package net.goodfoodonly.dao;

import net.goodfoodonly.dao.utils.ConnectionProxy;
import net.goodfoodonly.dao.utils.TransactionHelper;
import net.goodfoodonly.dao.utils.exceptions.user.DaoException;
import net.goodfoodonly.dao.utils.exceptions.user.UserAlreadyExistException;
import net.goodfoodonly.domains.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDao клас через який будуть здійснюватись запити в Базу даних що відносяться до користувача
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class UserDao {

    //  Параметр для метода createPreparedStatement(String) який викликається у методі saveUser(User user)
    private final static String INSERT_USER = "insert into webusers(name,surname,telephone,email,login,password,role) values(?,?,?,?,?,?,?)";

    //Параметр для метода createPreparedStatement(String) який викликається у методі getUserByLogin(String login)
    private final static String SELECT_USER = "select * from webusers where login=?";

    //Параметр для метода executeQuery(String) який викликається у методі getAllUser()
    private final static String SELECT_ALL_USER = "select * from webusers WHERE webusers.role='USER'";

    //Параметр для метода createPreparedStatement(String) який викликається у методі deleteUser(User user)
    private final static String DELETE_USER = "delete from webusers where webusers.login=?";

    /**
     * Конструктор класу UserDao.class
     */
    public UserDao() {
    }

    /**
     * Метод призначений для збереження даник про об'єкт класу User.class у БД через запит.
     *
     * @param user об'єкт класу User.class дані якого необхідно зберегти у БД.
     */
    public void saveUser(User user) {
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(INSERT_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getTelephone());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getLogin());
            statement.setString(6, user.getPassword());
            statement.setString(7, user.getRole());
            statement.execute();
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23000")) {
                throw new UserAlreadyExistException(ex);
            } else {
                throw new DaoException(ex);
            }
        }
    }

    /**
     * Метод призначений для видалення користувача по логіну із БД через запит.
     *
     * @param user Об'єкт класу User.class із заповненим полем "login".
     */
    public void deleteUser(User user) {
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(DELETE_USER);
            statement.setString(1, user.getLogin());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод призначений для отримання даних про користувача по логіну із БД через запит.
     *
     * @param login логін користувача інформацію про якого потрібно отримати.
     * @return об'єкт класу User.class із заповненими полями "name", "login", "password", "role".
     */
    public User getUserByLogin(String login) {
        User user = null;
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(SELECT_USER);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    /**
     * Метод призначений для отримання даних про  всіх користувачів із ролью "USER" із БД через запит.
     *
     * @return список із об'єктів класу User.class (лише із ролью "USER") із заповненими полями "name", "surname","telephone","email", "login", "password", "menu".
     */
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setMenu(resultSet.getString("menu"));
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return users;
    }
}
