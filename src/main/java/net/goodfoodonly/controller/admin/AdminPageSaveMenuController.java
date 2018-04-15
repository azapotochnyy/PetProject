package net.goodfoodonly.controller.admin;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.dao.utils.exceptions.menu.MenuExistException;
import net.goodfoodonly.dao.utils.exceptions.ServiceException;
import net.goodfoodonly.dto.MenuDTO;
import net.goodfoodonly.service.ServiceFactory;
import net.goodfoodonly.validation.DateValidator;
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
public class AdminPageSaveMenuController implements Controller {
    /**
     * Реалізація метода "execute" інтерфейсу "Controller" обробляє запроси GET по URI, що закінчується на "/savemenu".
     * Через метод getParameter() отримуються ключові параметри (name, breakfast, lunchone, dinner, lunchtwo, supper, lunchthree, date) меню що були внесені у форму користувачем.
     * Дані параметри проходять валідацію. У випадку не проходження валідації даних запит користувача знову перенаправляється на URI що закінчується на "/createmenu",
     * що в свою чергу контролером перенаправляє на jsp сторінку menupage.jsp. із зазначенням причини не проходження валідації.
     * У випадку проходження валідації даних - створюється об'єкт класу MenuDTO.class в конструктор якого передаються дані що пройшли валідацію.
     * А також викликається метод saveMenu(MenuDTO menuDTO) класу MenuServiceImpl.class який передає запит на запис інформації про меню в БД.
     *
     * @see net.goodfoodonly.service.MenuServiceImpl#saveMenu(MenuDTO)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String breakfast = request.getParameter("breakfast");
        String lunchOne = request.getParameter("lunchone");
        String dinner = request.getParameter("dinner");
        String lunchTwo = request.getParameter("lunchtwo");
        String supper = request.getParameter("supper");
        String lunchThree = request.getParameter("lunchthree");
        String date = request.getParameter("date");
        boolean validDateResult;
        DateValidator dateValidator = new DateValidator();
        validDateResult = dateValidator.validate(date);
        if (!RegExp.isCorrectMenu(breakfast)
                || !RegExp.isCorrectMenu(lunchOne)
                || !RegExp.isCorrectMenu(dinner)
                || !RegExp.isCorrectMenu(lunchTwo)
                || !RegExp.isCorrectMenu(supper)
                || !RegExp.isCorrectMenu(lunchThree)) {
            request.setAttribute("error", "Data in Breakfast or Lunch One or Two or Three or Dinner or Supper is too long or empty");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/createmenu");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!validDateResult) {
            request.setAttribute("error", "Data incorrect!");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/createmenu");
            try {
                try {
                    rd.forward(request, response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else if (validDateResult & RegExp.isCorrectMenu(breakfast)
                & RegExp.isCorrectMenu(lunchOne)
                & RegExp.isCorrectMenu(dinner)
                & RegExp.isCorrectMenu(lunchTwo)
                & RegExp.isCorrectMenu(supper)
                & RegExp.isCorrectMenu(lunchThree)) {
            try {

                MenuDTO menuDTO = new MenuDTO(name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date);
                ServiceFactory.getInstance().getMenuService().saveMenu(menuDTO);
                request.setAttribute("error", "Menu " + name + " has been created!");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/createmenu");
                try {
                    rd.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MenuExistException ex) {
                request.setAttribute("error", "Menu on this date already exists!");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/createmenu");
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
        }
    }
}
