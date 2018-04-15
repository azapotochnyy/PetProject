package net.goodfoodonly.controller.admin;


import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.MenuDTO;
import net.goodfoodonly.dto.UserDTO;
import net.goodfoodonly.service.MenuServiceImpl;
import net.goodfoodonly.service.ServiceFactory;
import net.goodfoodonly.service.UserServiceImpl;

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

public class ShowInfoController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/showinfo".
     * Метод getAllUsers() класу UserServiceImpl.class повертає список всіх користувачів, а метод
     * getAllMenusNames() класу MenuServiceImpl.class список всіх доступних меню.
     *
     * @see UserServiceImpl#getAllUsers()
     * @see MenuServiceImpl#getAllMenusNames()
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            try {
                List<UserDTO> usersDTO = ServiceFactory.getInstance().getUserService().getAllUsers();
                List<MenuDTO> menuDto = ServiceFactory.getInstance().getMenuService().getAllMenusNames();
                request.setAttribute("userdto", usersDTO);
                request.setAttribute("menudto", menuDto);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/showinfo.jsp");
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

