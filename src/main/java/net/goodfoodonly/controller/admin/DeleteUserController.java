package net.goodfoodonly.controller.admin;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.UserDTO;
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
public class DeleteUserController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/userdelete".
     * Через метод getParameter() отримується логін користувача, якого варто видалити.
     * Передані параметри зберігаються в об'єкті класу UserDTO.class
     * Об'єкт класу UserDTO.class передається в метод deleteUser(UserDTO userDTO) класу UserServiceImpl.class,
     * який служить для видалення конкретного користувача із БД.
     *
     * @see net.goodfoodonly.service.UserServiceImpl#deleteUser
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(request.getParameter("deleteuserlogin"));
            ServiceFactory.getInstance().getUserService().deleteUser(userDTO);
            request.setAttribute("userdelete", "Користувач " + userDTO.getLogin() + " був успішно видалений");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/showinfo");
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
