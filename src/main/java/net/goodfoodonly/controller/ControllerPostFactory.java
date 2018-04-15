package net.goodfoodonly.controller;

import net.goodfoodonly.controller.user.LoginController;
import net.goodfoodonly.controller.user.RegistrationController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика для створення контролерів, що будуть обробляти POST запити. Singleton.
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ControllerPostFactory implements ControllerFactory {
    private static ControllerFactory factory = new ControllerPostFactory();
    private Map<String, Controller> controllersMap = new HashMap<>();

    /**
     * Конструктор класу ControllerPostFactory.class без прараметрів.
     * В тілі конструктора створюються контролери що будуть обробляти POST запити.
     * Створені контролери поміщаються у колекцію Map <String, Controller>, де ключ (String),
     * а значення - об'єкти класів, що імплементують інтерфейс Controller.
     */
    private ControllerPostFactory() {
        controllersMap.put("login", new LoginController());
        controllersMap.put("registration", new RegistrationController());
    }

    /**
     * Метод призначений для того щоб оприділити який контролер буде обробляти запит користувача.
     * Викликається метод getRequestURI() у request, отриманий URI розбивається методом split("/") на строки
     * і записується в масив строк, остатній елемент якого використовується для порівняння із ключом із колекції Map.
     * Із колекції Map по ключу дістається контролер.
     *
     * @param request запит користувача.
     * @return об'єкт класу що імплементує інтерфейс Controller.
     */
    public Controller getController(HttpServletRequest request) {
        String[] req = request.getRequestURI().split("/");
        if (req.length == 0) {
            return controllersMap.get(null);
        }
        return controllersMap.get(req[req.length - 1]);
    }

    /**
     * @return об'єкт класу ControllerPostFactory.class
     */
    public static ControllerFactory getInstance() {
        return factory;
    }

}