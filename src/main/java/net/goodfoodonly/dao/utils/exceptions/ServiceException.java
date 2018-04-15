package net.goodfoodonly.dao.utils.exceptions;


/**
 * Exception пов'язане із виникненням виключення net.goodfoodonly.dao.utils.exceptions.user.DaoException.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class ServiceException extends RuntimeException {

    /**
     *
     * @param e DaoException.class
     */
    public ServiceException(Exception e) {
        super(e);
    }
}
