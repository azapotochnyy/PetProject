package net.goodfoodonly.controller.user;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.dao.utils.exceptions.ServiceException;
import net.goodfoodonly.dao.utils.exceptions.user.UserExistException;
import net.goodfoodonly.dto.UserDTO;
import net.goodfoodonly.service.ServiceFactory;
import net.goodfoodonly.validation.EmailValidator;
import net.goodfoodonly.validation.PhoneValidator;
import net.goodfoodonly.validation.RegExp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class RegistrationController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси POST по URI, що закінчується на "/registration".
     * Через метод getParameter(String) отримуються всі дані про нового користувача.
     * Отримані дані передаються для валідації. Якщо дані валідацію не пройшли, то надається відповідь користувачу через
     * jsp сторінку registration.jsp із повідомленням про причину не проходження валідації.
     * Якщо валідацію дані пройшли успішно, то через метод saveUser(UserDTO userDTO) передаються для збереження в БД
     * Користувач перенаправляється на jsp сторінку index.jsp.
     *
     * @see net.goodfoodonly.service.RegistrationServiceImpl#saveUser(UserDTO)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("username");
        String surname = request.getParameter("usersurname");
        String usertelephone = request.getParameter("usertelephone");
        String useremail = request.getParameter("useremail");
        String login = request.getParameter("userlogin");
        String password = request.getParameter("userpassword");
        String role = "USER";
        PhoneValidator phoneValidator = new PhoneValidator();
        EmailValidator emailValidator = new EmailValidator();
        if (!RegExp.isCorrectLoginName(login) ||
                !RegExp.isCorrectPassword(password)) {
            request.setAttribute("error", "Credentials incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!phoneValidator.validate(usertelephone)) {
            request.setAttribute("error", "Phone error");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!emailValidator.validate(useremail)) {
            request.setAttribute("error", "Email error");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!RegExp.isCorrectNameSurname(name)) {
            request.setAttribute("error", "Name length is longer than 60 or you use Numbers or Cyrillic alphabet");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!RegExp.isCorrectNameSurname(surname)) {
            request.setAttribute("error", "Surname length is longer than 60 or you use Numbers or Cyrillic alphabet");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            UserDTO userDTO = new UserDTO(name, surname, usertelephone, useremail, login, password, role);
            try {
                ServiceFactory.getInstance().getRegistrationService().saveUser(userDTO);
            } catch (UserExistException ex) {
                request.setAttribute("error", "User already exist!");
                RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                try {
                    rd.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (ServiceException ex) {
                ex.printStackTrace();
            }
            try {
                response.sendRedirect("/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
