package net.goodfoodonly.dao.utils.exceptions.menu;

/**
 * Exception пов'язане із виникненням java.sql.SQLException у методах об'єкту класу MenuDao.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class MenuDaoException extends RuntimeException {

    /**
     *
     * @param e java.sql.SQLException
     */
    public MenuDaoException(Exception e) {
        super(e);
    }

}

