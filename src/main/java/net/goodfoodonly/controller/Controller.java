package net.goodfoodonly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public interface Controller {
    /**
     *
     * @param request запит користувача
     * @param response відповідь користувачу
     */
    void execute(HttpServletRequest request, HttpServletResponse response);
}
