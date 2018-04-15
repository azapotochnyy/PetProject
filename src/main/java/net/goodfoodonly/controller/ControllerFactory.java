package net.goodfoodonly.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public interface ControllerFactory {
    /**
     * @param request запит користувача
     * @return об'єкт класу що імплементує інтерфейс Controller.
     */
    Controller getController(HttpServletRequest request);
}
