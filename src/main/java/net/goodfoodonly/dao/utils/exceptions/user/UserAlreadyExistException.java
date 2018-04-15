package net.goodfoodonly.dao.utils.exceptions.user;

/**
 * Exception пов'язане із виникненням java.sql.SQLException (23000) у методі saveUser(User user) об'єкту класу UserDao.class
 * Виникає при неможливості зберегти дані про користувача в БД, у звязку із вже існуючими в ній таких самих даних (UNIQUE).
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class UserAlreadyExistException extends RuntimeException {

    /**
     *
     * @param e java.sql.SQLException (23000)
     */
    public UserAlreadyExistException(Exception e) {
        super(e);
    }

}
