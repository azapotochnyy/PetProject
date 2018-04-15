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

public class DeleteMenuByDateController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/deletemenubydate".
     * Через метод getParameter() отримуються ім'я меню і дата на яку варто видалити меню.
     * Передані параметри зберігаються в об'єкті класу MenuDTO.class
     * Об'єкт класу MenuDTO.class передається в метод deleteMenuByDate(MenuDTO menuDTO) класу MenuServiceImpl.class,
     * який служить для видалення конкретного меню на конкретну дату.
     *
     * @see net.goodfoodonly.service.MenuServiceImpl#deleteMenuByDate(MenuDTO)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            MenuDTO menuDTO = new MenuDTO();
            String datemenu = request.getParameter("deleteuserlogin");
            String name = datemenu.substring(10);
            String date = datemenu.substring(0, 10);
            menuDTO.setDate(date);
            menuDTO.setName(name);
            ServiceFactory.getInstance().getMenuService().deleteMenuByDate(menuDTO);
            request.setAttribute("menubydatedelete", "Меню: " + menuDTO.getName() + " було успішно видалено " + "на Дату - " + menuDTO.getDate());
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
