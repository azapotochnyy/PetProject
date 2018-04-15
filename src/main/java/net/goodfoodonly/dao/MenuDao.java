package net.goodfoodonly.dao;

import net.goodfoodonly.dao.utils.ConnectionProxy;
import net.goodfoodonly.dao.utils.TransactionHelper;
import net.goodfoodonly.dao.utils.exceptions.menu.MenuAlreadyExistException;

import net.goodfoodonly.dao.utils.exceptions.menu.MenuDaoException;
import net.goodfoodonly.domains.Menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * MenuDao клас через який будуть здійснюватись запити в Базу даних що відносяться до меню
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class MenuDao {


    //Параметр для метода createPreparedStatement(String) який викликається у методі saveMenu(Menu menu)
    private final static String INSERT_MENU = "insert into menu (name, breakfast, lunch1, dinner, lunch2, supper, lunch3, menudate) values(?,?,?,?,?,?,?,?)";

    //Параметр для метода createPreparedStatement(String) який викликається у методі getAllMenuByDate(String login, String date)
    private final static String GET_ALL_MENU_BY_DATE = "select menu.name,menu.breakfast, menu.lunch1,menu.dinner,menu.lunch2,menu.supper,menu.lunch3,menu.menudate FROM menu, webusers WHERE menu.name=? AND menu.menudate =?";

    //Параметр для метода createPreparedStatement(String) який викликається у методі getMenuByDate(String login, String date)
    private final static String GET_MENU_BY_DATE = "select menu.name,menu.breakfast, menu.lunch1,menu.dinner,menu.lunch2,menu.supper,menu.lunch3,menu.menudate FROM menu, webusers WHERE webusers.LOGIN=? AND menu.menudate =?";

    //Параметр для метода createPreparedStatement(String) який викликається у методі setUpdateMenu(String login, String menu)
    private final static String UPDATE_MENU = "update webusers SET MENU=? where LOGIN=?";

    //Параметр для метода executeQuery(String) який викликається у методі getAllMenusNames()
    private final static String GET_MENU_NAME = "select distinct menu.name FROM menu";

    //Параметр для метода createPreparedStatement(String) який викликається у методі deleteMenu(Menu menu)
    private final static String DELETE_MENU = "delete from menu where menu.name=?";

    //Параметр для метода createPreparedStatement(String) який викликається у методі deleteMenuByDate(Menu menudate)
    private final static String DELETE_MENU_BY_DATE = "delete from menu where menu.menudate=? AND menu.name=?";

    //Параметр для метода createPreparedStatement(String) який викликається у методі getDateList(String menuname)
    private final static String GET_DATE_LIST = "select menu.menudate FROM menu where menu.name=?";

    //Параметр для метода createPreparedStatement(String) який викликається у методі getMenuNameByLogin(String login)
    private final static String GET_MENU_NAME_BY_LOGIN = "select webusers.menu FROM webusers where webusers.login=?";

    /**
     * Конструктор класу MenuDao.class
     */
    public MenuDao() {
    }

    /**
     * Метод призначений для отримання списка імен меню (що не повторюються) із БД через запит.
     *
     * @return Список із об'єктів класу MenuDTO.class із заповненим полем name.
     * @see MenuDao#GET_MENU_NAME
     */
    public List<Menu> getAllMenusNames() {
        List<Menu> menulist = new ArrayList<>();
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_MENU_NAME);
            while (resultSet.next()) {
                Menu menun = new Menu();
                menun.setName(resultSet.getString("name"));
                menulist.add(menun);
            }
        } catch (SQLException ex) {
            throw new MenuDaoException(ex);
        }
        return menulist;
    }

    /**
     * Метод призначений для отримання списка дат для одного меню із БД через запит.
     *
     * @param menuname ім'я меню для якого потрібно отримати список дат.
     * @return список із об'єктів класу Menu.class із заповненим полем date.
     */
    public List<Menu> getDateList(String menuname) {
        List<Menu> list = new ArrayList<>();
        Menu menu = null;
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(GET_DATE_LIST);
            statement.setString(1, menuname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                menu = new Menu();
                menu.setDate(resultSet.getString("menudate"));
                list.add(menu);
            }
        } catch (SQLException e) {
            throw new MenuDaoException(e);
        }
        return list;
    }

    /**
     * Метод призначений для збереження даник про об'єкт класу Menu.class у БД через запит.
     *
     * @param menu об'єкт класу Menu.class дані якого необхідно зберегти у БД.
     */
    public void saveMenu(Menu menu) {
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(INSERT_MENU);
            statement.setString(1, menu.getName());
            statement.setString(2, menu.getBreakfast());
            statement.setString(3, menu.getLunchOne());
            statement.setString(4, menu.getDinner());
            statement.setString(5, menu.getLunchTwo());
            statement.setString(6, menu.getSupper());
            statement.setString(7, menu.getLunchThree());
            statement.setString(8, menu.getDate());
            statement.execute();
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23000")) {
                throw new MenuAlreadyExistException(ex);
            } else {
                throw new MenuDaoException(ex);
            }
        }
    }

    /**
     * Метод призначений для отримання меню (Об'єкт класу Menu.class) для користувача на певну датут із БД через запит.
     *
     * @param login логін користувача для якого потрібно отримати меню.
     * @param date  дата на яку потрібно отримати меню.
     * @return меню (Об'єкт класу Menu.class із заповненими полями name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     */
    public Menu getMenuByDate(String login, String date) {
        Menu menu = null;
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(GET_MENU_BY_DATE);
            statement.setString(1, login);
            statement.setString(2, date);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                menu = new Menu();
                menu.setName(resultSet.getString("name"));
                menu.setBreakfast(resultSet.getString("breakfast"));
                menu.setLunchOne(resultSet.getString("lunch1"));
                menu.setDinner(resultSet.getString("dinner"));
                menu.setLunchTwo(resultSet.getString("lunch2"));
                menu.setSupper(resultSet.getString("supper"));
                menu.setLunchThree(resultSet.getString("lunch3"));
                menu.setDate(resultSet.getString("menudate"));
            }
        } catch (SQLException e) {
            throw new MenuDaoException(e);
        }
        return menu;
    }

    /**
     * Метод призначений для отримання меню (Об'єкт класу Menu.class) на певну дату по імені меню із БД через запит.
     *
     * @param menuname ім'я меню.
     * @param date     дата на яку потрібно отримати меню.
     * @return меню (Об'єкт класу Menu.class із заповненими полями name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     */
    public Menu getAllMenuByDate(String menuname, String date) {
        Menu menu = null;
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(GET_ALL_MENU_BY_DATE);
            statement.setString(1, menuname);
            statement.setString(2, date);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                menu = new Menu();
                menu.setName(resultSet.getString("name"));
                menu.setBreakfast(resultSet.getString("breakfast"));
                menu.setLunchOne(resultSet.getString("lunch1"));
                menu.setDinner(resultSet.getString("dinner"));
                menu.setLunchTwo(resultSet.getString("lunch2"));
                menu.setSupper(resultSet.getString("supper"));
                menu.setLunchThree(resultSet.getString("lunch3"));
                menu.setDate(resultSet.getString("menudate"));
            }
        } catch (SQLException e) {
            throw new MenuDaoException(e);
        }
        return menu;
    }

    /**
     * Метод призначений для назначення меню вибраному користувачу у БД через запит.
     *
     * @param login логін користувача якому назначається меню.
     * @param menu  ім'я меню яке назначається користувачу.
     */
    public void setUpdateMenu(String login, String menu) {

        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(UPDATE_MENU);
            statement.setString(1, menu);
            statement.setString(2, login);
            statement.execute();
        } catch (SQLException ex) {
            throw new MenuDaoException(ex);
        }
    }

    /**
     * Метод призначений для видалення меню по імені із БД через запит.
     *
     * @param menu Об'єкт класу Menu.class із заповненим полем "name".
     */
    public void deleteMenu(Menu menu) {
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(DELETE_MENU);
            statement.setString(1, menu.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод призначений для видаленя меню по імені на певну дату у БД через запит.
     *
     * @param menudate Об'єкт класу Menu.class із заповненими полями "name" та "date".
     */
    public void deleteMenuByDate(Menu menudate) {
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(DELETE_MENU_BY_DATE);
            statement.setString(1, menudate.getDate());
            statement.setString(2, menudate.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод призначений для отримання імені меню для користувача по логіну користувача із БД через запит.
     *
     * @param login логін користувача для якого потрібно дізнатись назначене меню.
     * @return ім'я меню, що назначене користувачу.
     */
    public String getMenuNameByLogin(String login) {
        String a = "";
        try (ConnectionProxy connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.createPreparedStatement(GET_MENU_NAME_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                a = resultSet.getString("menu");
            }

        } catch (SQLException e) {
            throw new MenuDaoException(e);
        }
        return a;
    }
}






