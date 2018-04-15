package net.goodfoodonly.service;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ServiceFactory {

    /**
     * Створення єдиного екземпляру класу ServiceFactory.class
     */
    private static ServiceFactory instance = new ServiceFactory();

    /**
     * Створення посилання на об'єкт класу UserServiceImpl.class
     */
    private UserService userService = new UserServiceImpl();

    /**
     * Створення посилання на об'єкт класу LoginServiceImpl.class
     */
    private LoginService loginService = new LoginServiceImpl();

    /**
     * Створення посилання на об'єкт класу RegistrationServiceImpl.class
     */
    private RegistrationService registrationService = new RegistrationServiceImpl();

    /**
     * Створення посилання на об'єкт класу MenuServiceImpl.class
     */
    private MenuService menuService = new MenuServiceImpl();

    /**
     * Конструктор класу ServiceFactory.class із класифікатором доступу private
     */
    private ServiceFactory() {
    }

    /**
     * Геттер для ServiceFactory.class
     *
     * @return instance ServiceFactory.class
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

    /**
     * Повертає ссилку на UserServiceImpl.class
     *
     * @return ссилку на UserServiceImpl.class
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Повертає ссилку на LoginServiceImpl.class
     *
     * @return ссилку на LoginServiceImpl.class
     */
    public LoginService getLoginService() {
        return loginService;
    }

    /**
     * Повертає ссилку на RegistrationServiceImpl.class
     *
     * @return ссилку на RegistrationServiceImpl.class
     */
    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    /**
     * Повертає ссилку на MenuServiceImpl.class
     *
     * @return ссилку на MenuServiceImpl.class
     */
    public MenuService getMenuService() {
        return menuService;
    }
}
