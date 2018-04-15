package net.goodfoodonly.service;

import net.goodfoodonly.dao.DaoFactory;
import net.goodfoodonly.dao.utils.exceptions.user.DaoException;
import net.goodfoodonly.dao.utils.exceptions.ServiceException;
import net.goodfoodonly.domains.User;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class LoginServiceImpl implements LoginService {
    /**
     * Метод для отриманя об'єкту класу User.class через логін і пароль
     *
     * @param login    логін користувача (роль "ADMIN" або "USER")
     * @param password пароль користувача (ролью "ADMIN" або "USER")
     * @return User user
     * @see net.goodfoodonly.dao.UserDao#getUserByLogin(String)
     */
    @Override
    public User loginVerify(String login, String password) {
        User user;
        try {
            user = DaoFactory.getInstance().getUserDao().getUserByLogin(login);
            if (user == null || !user.getPassword().equals(password)) {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }
}