package net.goodfoodonly.controller.user;

import net.goodfoodonly.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class LogOutController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/logout".
     * Метод закриває сесію, якщо вона відкрита, та перенаправляє користувача на jsp сторінку index.jsp.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        try {
            response.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

