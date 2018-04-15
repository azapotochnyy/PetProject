package net.goodfoodonly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class IndexController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller". Запит перенаправляється на jsp сторінку index.jsp. (Welcome page)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
