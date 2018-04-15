package net.goodfoodonly.dao;

/**
 * Створення Singleton Factory
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class DaoFactory {

    /**
     * Створення єдиного екземпляру класу DaoFactory.class
     */
    private static DaoFactory instance = new DaoFactory();

    /**
     * Створення єдиного екземпляру класу UserDao.class
     */
    private UserDao userDao = new UserDao();

    /**
     * Створення єдиного екземпляру класу MenuDao.class
     */
    private MenuDao menuDao = new MenuDao();

    /**
     * Конструктор класу DaoFactory.class із класифікатором доступу private
     */
    private DaoFactory() {
    }

    /**
     * Геттер для DaoFactory.class
     *
     * @return instance ServiceFactory.class
     */
    public static DaoFactory getInstance() {
        return instance;
    }

    /**
     * Геттер для UserDao.class
     *
     * @return userDao UserDao.class
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * Геттер для MenuDao.class
     *
     * @return menuDao MenuDao.class
     */
    public MenuDao getMenuDao() {
        return menuDao;
    }
}
