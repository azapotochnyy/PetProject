package net.goodfoodonly.service;

import net.goodfoodonly.dao.DaoFactory;
import net.goodfoodonly.dao.UserDao;
import net.goodfoodonly.dao.utils.TransactionHelper;
import net.goodfoodonly.dao.utils.exceptions.user.DaoException;
import net.goodfoodonly.dao.utils.exceptions.ServiceException;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    /**
     * Метод призначений для отримання списку користуввачів та даних про них.
     *
     * @return повертає список користувачів (List об'єктів класу UserDTO.class)
     * @see UserDao#getAllUser()
     */
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> usersDTO = null;
        try {
            List<User> users = DaoFactory.getInstance().getUserDao().getAllUser();
            usersDTO = users.stream()
                    .map(user -> new UserDTO.Builder()
                            .setName(user)
                            .setSurname(user)
                            .setTelephone(user)
                            .setEmail(user)
                            .setLogin(user)
                            .setPassword(user)
                            .setMenu(user)
                            .setRole(user).build())
                    .collect(Collectors.toList());
        } catch (DaoException ex) {
            return usersDTO;
        }
        return usersDTO;
    }

    /**
     * Метод призначений для видалення користувача.
     *
     * @param userDTO об'єкт класу UserDTO.class для видалення
     * @see UserDao#deleteUser(User)
     */
    @Override
    public void deleteUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        try {
            TransactionHelper.getInstance().beginTransaction();
            DaoFactory.getInstance().getUserDao().deleteUser(user);
            TransactionHelper.getInstance().commit();
        } catch (DaoException ex) {
            TransactionHelper.getInstance().rollback();
            throw new ServiceException(ex);
        }
    }
}
