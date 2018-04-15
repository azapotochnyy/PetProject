package net.goodfoodonly.controller.forward;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ForwardToDeletePageUserController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/forwardtodeleteuserpage.
     * Даний метод призначений для того, щоб після прийняття рішення користувачем
     * із ролью "ADMIN" видалити із бази вибраного користувача із ролью "USER" ще раз підтвердити свої дії.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null & user.getRole().equals("ADMIN")) {
            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(request.getParameter("deleteuserlogin"));
            request.setAttribute("userdelete", "Ви збираєтесь видалити користувача " + userDTO.getLogin() + "? Якщо ТАК нажміть на кнопку нижче");
            request.setAttribute("deleteuserlogin", userDTO.getLogin());
            String controleruri = "/userdelete";
            request.setAttribute("controller", controleruri);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/deletepage.jsp");
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
