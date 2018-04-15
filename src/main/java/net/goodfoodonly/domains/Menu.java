package net.goodfoodonly.domains;

import net.goodfoodonly.dto.MenuDTO;

import java.io.Serializable;

/**
 * Клас призначений для створення меню для користувача.
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class Menu implements Serializable {
    private Long id;
    private String name;
    private String breakfast;
    private String lunchOne;
    private String dinner;
    private String lunchTwo;
    private String supper;
    private String lunchThree;
    private String date;

    /**
     * Конструктор класу Menu.class без параметрів.
     *
     * @see Menu#Menu(Long, String, String, String, String, String, String, String, String)
     */
    public Menu() {
    }

    /**
     * Конструктор класу Menu.class з параметрами.
     *
     * @param id id меню.
     * @param name ім'я меню.
     * @param breakfast що на сніданок.
     * @param lunchOne що на перший перекус.
     * @param dinner що на обід.
     * @param lunchTwo що на другий перекус.
     * @param supper що на вечерю.
     * @param lunchThree що на третій перекус.
     * @param date дата меню.
     *
     * @see Menu#Menu()
     */
    public Menu(Long id, String name, String breakfast, String lunchOne, String dinner, String lunchTwo, String supper, String lunchThree, String date) {
        this.id = id;
        this.name = name;
        this.breakfast = breakfast;
        this.lunchOne = lunchOne;
        this.dinner = dinner;
        this.lunchTwo = lunchTwo;
        this.supper = supper;
        this.lunchThree = lunchThree;
        this.date = date;
    }

    /**
     * Створення статичного класу Builder, щоб із об'єкта класу MenuDTO.class створювати об'єкта класу Menu.class
     */
    public static class Builder {
        Menu menu = new Menu();

        /**
         * Метод призначений для того, щоб записати в поле "name" об'єкту класу Menu.class значення поля "name" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setName(MenuDTO menuDTO) {
            menu.setName(menuDTO.getName());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "breakfast" об'єкту класу Menu.class значення поля "breakfast" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setBreakfast(MenuDTO menuDTO) {
            menu.setBreakfast(menuDTO.getBreakfast());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "lunchOne" об'єкту класу Menu.class значення поля "lunchOne" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setLunchOne(MenuDTO menuDTO) {
            menu.setLunchOne(menuDTO.getLunchOne());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "dinner" об'єкту класу Menu.class значення поля "dinner" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setDinner(MenuDTO menuDTO) {
            menu.setDinner(menuDTO.getDinner());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "lunchTwo" об'єкту класу Menu.class значення поля "lunchTwo" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setLunchTwo(MenuDTO menuDTO) {
            menu.setLunchTwo(menuDTO.getLunchTwo());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "supper" об'єкту класу Menu.class значення поля "supper" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setSupper(MenuDTO menuDTO) {
            menu.setSupper(menuDTO.getSupper());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "lunchThree" об'єкту класу Menu.class значення поля "luncThree" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setLunchThree(MenuDTO menuDTO) {
            menu.setLunchThree(menuDTO.getLunchThree());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "date" об'єкту класу Menu.class значення поля "date" об'єкту класу MenuDTO.class та вернути ссилку на Menu.Builder
         *
         * @param menuDTO об'єкта класу MenuDTO.class
         * @return посилання на Menu.Builder
         */
        public Menu.Builder setDate(MenuDTO menuDTO) {
            menu.setDate(menuDTO.getDate());
            return this;
        }

        /**
         * Метод призначений для видачі об'єкту класу Меnu.class
         *
         * @return об'єкт класу Меnu.class
         */
        public Menu build() {
            return menu;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunchOne() {
        return lunchOne;
    }

    public void setLunchOne(String lunchOne) {
        this.lunchOne = lunchOne;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getLunchTwo() {
        return lunchTwo;
    }

    public void setLunchTwo(String lunchTwo) {
        this.lunchTwo = lunchTwo;
    }

    public String getSupper() {
        return supper;
    }

    public void setSupper(String supper) {
        this.supper = supper;
    }

    public String getLunchThree() {
        return lunchThree;
    }

    public void setLunchThree(String lunchThree) {
        this.lunchThree = lunchThree;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breakfast='" + breakfast + '\'' +
                ", lunchOne='" + lunchOne + '\'' +
                ", dinner='" + dinner + '\'' +
                ", lunchTwo='" + lunchTwo + '\'' +
                ", supper='" + supper + '\'' +
                ", lunchThree='" + lunchThree + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
