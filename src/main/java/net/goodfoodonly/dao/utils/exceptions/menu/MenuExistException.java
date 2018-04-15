package net.goodfoodonly.dao.utils.exceptions.menu;

/**
 * Exception пов'язане із виникненням виключенням net.goodfoodonly.dao.utils.exceptions.menu.MenuAlreadyExistException.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class MenuExistException extends RuntimeException {

    /**
     *
     * @param ex MenuAlreadyExistException.class
     */
    public MenuExistException(Exception ex) {
        super(ex);
    }
}
