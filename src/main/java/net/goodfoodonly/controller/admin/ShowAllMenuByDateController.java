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
public class ShowAllMenuByDateController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/allmenubydate".
     * Через метод getParameter() отримуються ключові параметри (menuname, date).
     * Через метод getAllMenuByDate(String menuname, String date) класу MenuServiceImpl.class здійснюється запит у БД, метод повертає об'єкт класу MenuDTO.class.
     * Тобто ціле меню на певну дату.
     * У випадку вдалого запиту до БД - response (разом із всіма отриманими атрибутами) передається користувачу через adminpageshowmenubydate.jsp
     * У випадку відсутності інформації в БД по відповідному запиту, запит перенаправляється на URI, що закінчується на "/adminpagemenu", що, в свою чергу,
     * передає response через adminpage.jsp із відповідним атрибутом("error", "No menu for this date").
     *
     * @see net.goodfoodonly.service.MenuServiceImpl#getAllMenuByDate(String, String)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String menuname = request.getParameter("menuname");
        String date = request.getParameter("date");
        try {
            MenuDTO menuDTO = ServiceFactory.getInstance().getMenuService().getAllMenuByDate(menuname, date);
            RequestDispatcher rd = null;
            if (menuDTO != null) {
                request.setAttribute("name", menuDTO.getName());
                request.setAttribute("breakfast", menuDTO.getBreakfast());
                request.setAttribute("lunchOne", menuDTO.getLunchOne());
                request.setAttribute("dinner", menuDTO.getDinner());
                request.setAttribute("lunchTwo", menuDTO.getLunchTwo());
                request.setAttribute("supper", menuDTO.getSupper());
                request.setAttribute("lunchThree", menuDTO.getLunchThree());
                request.setAttribute("date", menuDTO.getDate());
                rd = request.getRequestDispatcher("/WEB-INF/jsp/adminpageshowmenubydate.jsp");
            } else {
                request.setAttribute("error", "No menu for this date");
                rd = request.getRequestDispatcher("/WEB-INF/jsp/adminpagemenu");
            }
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






