package net.goodfoodonly.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Клас містить метод для проведення валідації даних (адреси електронної пошти користувача).
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class EmailValidator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern pattern;
    private Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
     * Метод призначений для проведення валідації даних(адреси електронної пошти користувача).
     *
     * @param date адреса електронної пошти користувача.
     * @return true - якщо валідація успішна, false - якщо дані валідацію не пройшли.
     */
    public boolean validate(String date) {
        matcher = pattern.matcher(date);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
}



