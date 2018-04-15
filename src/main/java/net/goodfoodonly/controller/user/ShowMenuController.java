package net.goodfoodonly.controller.user;


import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.MenuDTO;
import net.goodfoodonly.service.ServiceFactory;
import net.goodfoodonly.validation.DateValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ShowMenuController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/showmenu".
     * Через метод getParameter(String) отримуємо дані про дату, а із сесії отримуємо дані про користувача (login).
     * Через метод getMenuByDate(String userlogin, String date) отримуємо меню для користувача
     * на певну дату та через jsp сторінку infoforuser.jsp надаємо відповідь користувачу.
     *
     * @see net.goodfoodonly.service.MenuServiceImpl#getMenuByDate(String, String)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        String userlogin = user.getLogin();
        String date = request.getParameter("date");

        try {
            MenuDTO menuDTO = ServiceFactory.getInstance().getMenuService().getMenuByDate(userlogin, date);
            RequestDispatcher rd = null;
            if (menuDTO != null) {
                request.setAttribute("name", menuDTO.getName());
                request.setAttribute("breakfast", menuDTO.getBreakfast());
                request.setAttribute("lunchOne", menuDTO.getLunchOne());
                request.setAttribute("dinner", menuDTO.getDinner());
                request.setAttribute("lunchTwo", menuDTO.getLunchTwo());
                request.setAttribute("supper", menuDTO.getSupper());
                request.setAttribute("lunchThree", menuDTO.getLunchThree());
                request.setAttribute("date", menuDTO.getDate());
                rd = request.getRequestDispatcher("/WEB-INF/jsp/infoforuser.jsp");
            }
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}