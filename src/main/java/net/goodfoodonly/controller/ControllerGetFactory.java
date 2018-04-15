package net.goodfoodonly.controller;

import net.goodfoodonly.controller.admin.*;
import net.goodfoodonly.controller.forward.*;
import net.goodfoodonly.controller.user.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика для створення контролерів, що будуть обробляти GET запити.
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ControllerGetFactory implements ControllerFactory {
    private static ControllerFactory factory = new ControllerGetFactory();
    private Map<String, Controller> controllersMap = new HashMap<>();

    /**
     * Конструктор класу ControllerGetFactory.class без прараметрів.
     * В тілі конструктора створюються контролери що будуть обробляти GET запити.
     * Створені контролери поміщаються у колекцію Map <String, Controller>, де ключ (String),
     * а значення - об'єкти класів, що імплементують інтерфейс Controller.
     */
    private ControllerGetFactory() {
        controllersMap.put("registration", new RegistrationGetController());
        controllersMap.put("login", new LoginGetController());
        controllersMap.put(null, new IndexController());
        controllersMap.put("showinfo", new ShowInfoController());
        controllersMap.put("logout", new LogOutController());
        controllersMap.put("adminpage", new AdminPageController());
        controllersMap.put("savemenu", new AdminPageSaveMenuController());
        controllersMap.put("userpage", new InfoForUserController());
        controllersMap.put("showmenu", new ShowMenuController());
        controllersMap.put("insertmenu", new UpdateMenuController());
        controllersMap.put("createmenu", new ForwardToCreateMenuController());
        controllersMap.put("adminpagemenu", new AdminPageMenuController());
        controllersMap.put("userdelete", new DeleteUserController());
        controllersMap.put("menudelete", new DeleteMenuController());
        controllersMap.put("forwardtodeleteuserpage", new ForwardToDeletePageUserController());
        controllersMap.put("forwardtodeletemenupage", new ForwardToDeletePageMenuController());
        controllersMap.put("allmenubydate", new ShowAllMenuByDateController());
        controllersMap.put("alldatebymenu", new ShowDateByMenuNameController());
        controllersMap.put("deletemenubydate", new DeleteMenuByDateController());
        controllersMap.put("forwardtodeletemenupagebydate", new ForwardToDeletePageMenuByDateController());
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
        //System.out.println(request.getRequestURI());
        String[] req = request.getRequestURI().split("/");
        if (req.length == 0) {
            return controllersMap.get(null);
        }
        return controllersMap.get(req[req.length - 1]);
    }

    /**
     *
     * @return об'єкт класу ControllerGetFactory.class
     */
    public static ControllerFactory getInstance() {
        return factory;
    }
}