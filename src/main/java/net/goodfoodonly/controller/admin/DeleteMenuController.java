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

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class DeleteMenuController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/menudelete".
     * Через метод getParameter() отримується ім'я меню яке варто видалити.
     * Передані параметри зберігаються в об'єкті класу MenuDTO.class
     * Об'єкт класу MenuDTO.class передається в метод deleteMenu(MenuDTO menuDTO) класу MenuServiceImpl.class,
     * який служить для видалення конкретного меню в цілому.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setName(request.getParameter("deleteuserlogin"));
            ServiceFactory.getInstance().getMenuService().deleteMenu(menuDTO);
            request.setAttribute("menudelete", "Меню: " + menuDTO.getName() + " було успішно видалено");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/adminpagemenu");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
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
