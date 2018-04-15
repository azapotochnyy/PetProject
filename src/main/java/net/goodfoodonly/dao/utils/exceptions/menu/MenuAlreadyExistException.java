package net.goodfoodonly.dao.utils.exceptions.menu;

/**
 * Exception пов'язане із виникненням java.sql.SQLException (23000) у методі saveMenu(Menu menu) об'єкту класу MenuDao.class
 * Виникає при неможливості зберегти дані про меню користувача в БД, у звязку із вже існуючими в ній таких самих даних (UNIQUE).
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class MenuAlreadyExistException extends RuntimeException {

    /**
     *
     * @param e java.sql.SQLException (23000)
     */
    public MenuAlreadyExistException(Exception e) {
        super (e);
    }

}
