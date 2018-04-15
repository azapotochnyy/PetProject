package net.goodfoodonly.service;

import net.goodfoodonly.domains.User;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public interface LoginService {

    /**
     * @param login    логін користувача (роль "ADMIN" або "USER")
     * @param password пароль користувача (ролью "ADMIN" або "USER")
     * @return User user
     */
    User loginVerify(String login, String password);
}
