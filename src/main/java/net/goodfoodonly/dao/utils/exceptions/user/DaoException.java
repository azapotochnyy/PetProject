package net.goodfoodonly.dao.utils.exceptions.user;

/**
 * Exception пов'язане із виникненням java.sql.SQLException у методах об'єкту класу UserDao.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class DaoException extends RuntimeException {

    /**
     *
     * @param e java.sql.SQLException
     */
    public DaoException(Exception e) {
        super(e);
    }

}

