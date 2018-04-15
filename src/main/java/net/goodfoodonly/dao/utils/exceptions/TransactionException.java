package net.goodfoodonly.dao.utils.exceptions;

import net.goodfoodonly.dao.utils.TransactionHelper;

/**
 * Може виникнути у методах commit/rollback об'єкта класу TransactionHelper.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 * @see TransactionHelper#commit()
 * @see TransactionHelper#rollback()
 */
public class TransactionException extends RuntimeException {
    /**
     * Конструктор без параметрів
     */
    public TransactionException() {
    }
}