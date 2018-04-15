package net.goodfoodonly.controller.forward;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ForwardToCreateMenuController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/createmenu.
     * Даний метод призначений для того, щоб перенаправити користувача
     * із ролью "ADMIN" на сторінку із формою для створення меню (menupage.jsp).
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            try {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/menupage.jsp");
                try {
                    rd.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}