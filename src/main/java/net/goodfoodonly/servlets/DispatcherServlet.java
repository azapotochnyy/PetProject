package net.goodfoodonly.servlets;

import net.goodfoodonly.controller.Controller;
import net.goodfoodonly.controller.ControllerGetFactory;
import net.goodfoodonly.controller.ControllerPostFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Клас призначений для розподілу відповідного отриманого запросу від користувача відповідному контролеру для його опрацювання та підготовки відповіді.
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class DispatcherServlet extends HttpServlet {

    /**
     * Метод doGet передає get запити на опрацювання відповідному контролеру.
     *
     * @param req  get запит.
     * @param resp відповідь на get запит.
     * @see ControllerGetFactory#getController(HttpServletRequest)
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = ControllerGetFactory.getInstance().getController(req);
        controller.execute(req, resp);
    }

    /**
     * Метод doPost передає post запити на опрацювання відповідному контролеру.
     *
     * @param req  post запит.
     * @param resp відповідь на post запит.
     * @see ControllerPostFactory#getController(HttpServletRequest)
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = ControllerPostFactory.getInstance().getController(req);
        controller.execute(req, resp);
    }
}
