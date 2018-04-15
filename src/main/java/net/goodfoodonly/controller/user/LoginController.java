package net.goodfoodonly.controller.user;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.service.ServiceFactory;
import net.goodfoodonly.validation.RegExp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class LoginController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси POST по URI, що закінчується на "/login".
     * Через метод getParameter(String) отримуються дані про логін і пароль що вніс у форму користувач.
     * Отримані дані передаються для валідації. Якщо дані валідацію не пройшли, то надається відповідь користувачу через
     * jsp сторінку login.jsp із повідомленням про причину не проходження валідації.
     * Якщо валідацію дані пройшли успішно, то через метод loginVerify(String login, String password) отримуємо об'єкт класу User.class
     * Слідом за цим створюємо сесію і передаємо в сесію об'єкт класу User.class
     * В залежності від того який об'єкт класу User.class ми отримали (із заповненим полем role "USER" чи "ADMIN")
     * response перенаправляється на відповідний URI.
     *
     * @see net.goodfoodonly.service.LoginServiceImpl#loginVerify(String, String)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("userlogin");
        String password = request.getParameter("userpassword");
        String role;
        if (!RegExp.isCorrectLoginName(login) || !RegExp.isCorrectPassword(password)) {
            request.setAttribute("error", "Login incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user = ServiceFactory.getInstance().getLoginService().loginVerify(login, password);
        if (user == null) {
            request.setAttribute("error", "Login incorrect!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        role = user.getRole();
        try {
            if (role.equals("ADMIN")) {
                response.sendRedirect("jsp/adminpage");
            } else {
                response.sendRedirect("jsp/userpage");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
