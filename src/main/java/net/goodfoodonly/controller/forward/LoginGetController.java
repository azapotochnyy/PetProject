package net.goodfoodonly.controller.forward;

import net.goodfoodonly.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class LoginGetController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/login".
     * Запит користувача перенаправляється на jsp сторінку login.jsp що містить форму для введення логіна і пароля для входження.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
