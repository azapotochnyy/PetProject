package net.goodfoodonly.controller.forward;

import net.goodfoodonly.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class RegistrationGetController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/registration".
     * Запит користувача перенаправляється на jsp сторінку registration.jsp що містить форму для заповнення і проходження регістрації.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/registration.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}