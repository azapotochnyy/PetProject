package net.goodfoodonly.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Клас містить методи для проведення валідації даних ("логіна", "пароля", "імені", "прізвища", ключових полів об'єктів класів МеnuDTO/Menu.class).
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class RegExp {

    /**
     * Метод призначений для валідації логіна користувача.
     *
     * @param data логін користувача.
     * @return true - якщо валідація успішна, false - якщо дані валідацію не пройшли.
     */
    public static boolean isCorrectLoginName(String data) {
        if (data.equals(null)) return false;
        if (data.length() < 3) return false;

        String scriptStartCondition = "<script>\\w+";
        Pattern p = Pattern.compile(scriptStartCondition);
        Matcher m = p.matcher(data);
        if (m.matches()) return false;

        String scriptEndCondition = "\\w+</script>";
        p = Pattern.compile(scriptEndCondition);
        m = p.matcher(data);
        if (m.matches()) return false;

        //if not correct, has <script>
        String scriptCondition = "<script>\\w+</script>";
        p = Pattern.compile(scriptCondition);
        m = p.matcher(data);
        if (m.matches()) return false;

        ///if login starts from number
        String firstNumberCondition = "\\d+\\w+";
        p = Pattern.compile(firstNumberCondition);
        m = p.matcher(data);
        if (m.matches()) return false;

        return true;
    }

    /**
     * Метод призначений для валідації пароля користувача.
     *
     * @param data пароль користувача.
     * @return true - якщо валідація успішна, false - якщо дані валідацію не пройшли.
     */
    public static boolean isCorrectPassword(String data) {
        if (data.equals(null)) return false;
        if (data.length() < 5) return false;

        ///if password starts from number
        String firstNumberCondition = "\\d+\\w+";
        Pattern p = Pattern.compile(firstNumberCondition);
        Matcher m = p.matcher(data);
        if (m.matches()) return false;

        return true;
    }

    /**
     * Метод призначений для валідації імені тп прізвища користувача.
     *
     * @param data ім'я або прізвище користувача.
     * @return true - якщо валідація успішна, false - якщо дані валідацію не пройшли.
     */
    public static boolean isCorrectNameSurname(String data) {
        if (data.equals(null)) return false;
        if (data.length() > 40) return false;

        String a = "^[a-zA-Z]+$";
        Pattern p = Pattern.compile(a);
        Matcher m = p.matcher(data);
        if (m.matches()) return true;
        return false;
    }

    /**
     * Метод призначений для валідації даних що будуть записані в поля об'єктів класу MenuDTO.class.
     *
     * @param data дані для "breakfast", "lunchOne", "dinner", "lunchTwo", "supper", "lunchThree".
     * @return true - якщо валідація успішна, false - якщо дані валідацію не пройшли.
     */
    public static boolean isCorrectMenu(String data) {
        boolean a = true;
        if (data.equals("")) {
            a = false;
        } else if (data.length() > 200) {
            a = false;
        }
        return a;
    }
}




