package net.goodfoodonly.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Клас містить метод для проведення валідації даних (номеру телефона користувача).
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class PhoneValidator {
    private static final String PHONE_PATTERN = "^(1\\-)?[0-9]{4}\\-?[0-9]{4}\\-?[0-9]{4}$";
    private final Pattern pattern;
    private Matcher matcher;

    public PhoneValidator() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    /**
     * Метод призначений для проведення валідації номеру телефона користувача.
     *
     * @param date номер телефону користувача.
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
