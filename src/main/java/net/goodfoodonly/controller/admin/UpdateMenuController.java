package net.goodfoodonly.controller.admin;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */

public class UpdateMenuController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/insertmenu".
     * Через метод getParameter() отримуються ключові параметри (login, menuname).
     * Метод updateMenu(String login, String menuName) класу MenuServiceImpl.class назначає користувачу меню.
     *
     * @see net.goodfoodonly.service.MenuServiceImpl#updateMenu(String, String)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String menuName = request.getParameter("menuname");
        if (menuName == "") {
            request.setAttribute("error", " name is empty");
            RequestDispatcher rd = request.getRequestDispatcher("/showinfo");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ServiceFactory.getInstance().getMenuService().updateMenu(login, menuName);
            RequestDispatcher rd = request.getRequestDispatcher("/showinfo");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
