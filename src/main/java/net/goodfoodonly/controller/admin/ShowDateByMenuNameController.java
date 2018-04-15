package net.goodfoodonly.controller.admin;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.MenuDTO;
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

public class ShowDateByMenuNameController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/alldatebymenu".
     * Метод getDateList(String name) класу MenuServiceImpl.class - повертає список дат для одного меню.
     *
     * @see net.goodfoodonly.service.MenuServiceImpl#getDateList(String)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null | user.getRole().equals("USER")) {
            try {
                response.sendRedirect("/index.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String name = request.getParameter("showdate");
        List<MenuDTO> menuDTO = ServiceFactory.getInstance().getMenuService().getDateList(name);
        request.setAttribute("name", name);
        request.setAttribute("date", menuDTO);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/showdatebymenuforadmin.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

