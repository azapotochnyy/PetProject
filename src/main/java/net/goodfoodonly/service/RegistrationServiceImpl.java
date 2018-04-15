package net.goodfoodonly.service;

import net.goodfoodonly.dao.DaoFactory;
import net.goodfoodonly.dao.utils.TransactionHelper;
import net.goodfoodonly.dao.utils.exceptions.user.DaoException;
import net.goodfoodonly.dao.utils.exceptions.ServiceException;
import net.goodfoodonly.dao.utils.exceptions.user.UserAlreadyExistException;
import net.goodfoodonly.dao.utils.exceptions.user.UserExistException;
import net.goodfoodonly.domains.User;
import net.goodfoodonly.dto.UserDTO;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * Метод призначений зберігати дані користувача(об'єкта класу UserDTO.class).
     *
     * @param userDTO Об'єкт класу UserDTO.class із полями (name, surname, telephone, email, login, password, role).
     * @see net.goodfoodonly.dao.UserDao#saveUser(User)
     */
    @Override
    public void saveUser(UserDTO userDTO) {
        try {
            TransactionHelper.getInstance().beginTransaction();
            User user = new User.Builder()
                    .setName(userDTO)
                    .setSurname(userDTO)
                    .setTelephone(userDTO)
                    .setEmail(userDTO)
                    .setLogin(userDTO)
                    .setPassword(userDTO)
                    .setRole(userDTO)
                    .build();
            DaoFactory.getInstance().getUserDao().saveUser(user);
            TransactionHelper.getInstance().commit();
        } catch (DaoException ex) {
            TransactionHelper.getInstance().rollback();
            throw new ServiceException(ex);
        } catch (UserAlreadyExistException ex) {
            TransactionHelper.getInstance().rollback();
            throw new UserExistException(ex);
        }
    }
}