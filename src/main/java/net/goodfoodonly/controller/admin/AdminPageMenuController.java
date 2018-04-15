package net.goodfoodonly.controller.admin;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.MenuDTO;
import net.goodfoodonly.service.MenuServiceImpl;
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
public class AdminPageMenuController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/adminpagemenu".
     * Із сесії отримується "user". Якщо "user's Role equals "Admin" - запит перенаправляється на adminpagemenu.jsp
     * у іншому випадку перенаправляється на index.jsp.
     * Метод getAllMenusNames() класу MenuServiceImpl.class повертає список із всіх наявних меню.
     *
     * @see MenuServiceImpl#getAllMenusNames()
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            try {
                List<MenuDTO> menulist = ServiceFactory.getInstance().getMenuService().getAllMenusNames();
                request.setAttribute("menulist", menulist);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/adminpagemenu.jsp");
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
