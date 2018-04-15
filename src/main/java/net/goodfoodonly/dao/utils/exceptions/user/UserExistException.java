package net.goodfoodonly.dao.utils.exceptions.user;

/**
 * Exception пов'язане із виникненням виключенням net.goodfoodonly.dao.utils.exceptions.user.UserAlreadyExistException.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class UserExistException extends RuntimeException {

    /**
     * @param ex UserAlreadyExistException.class
     */
    public UserExistException(Exception ex) {
        super(ex);
    }

}
