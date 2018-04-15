package net.goodfoodonly.controller.user;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.MenuDTO;
import net.goodfoodonly.dto.UserDTO;
import net.goodfoodonly.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class InfoForUserController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/userpage".
     * Метод getMenuNameByLogin(String login) - повертає ім'я меню яке назначене користувачу.
     * Метод getDateList(String) - повертає список дат на які доступне меню.
     * Список дат доступних для меню для користувача передається через jsp сторінку userpage.jsp.
     *
     * @see net.goodfoodonly.dao.MenuDao#getMenuNameByLogin(String)
     * @see net.goodfoodonly.dao.MenuDao#getDateList(String)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            try {
                response.sendRedirect("/index.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String menuname = ServiceFactory.getInstance().getMenuService().getMenuNameByLogin(user.getLogin());
        List<MenuDTO> menuDTO = ServiceFactory.getInstance().getMenuService().getDateList(menuname);
        request.setAttribute("date", menuDTO);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userpage.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

