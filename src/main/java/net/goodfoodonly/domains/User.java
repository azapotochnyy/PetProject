package net.goodfoodonly.domains;

import net.goodfoodonly.dto.UserDTO;

import java.io.Serializable;

/**
 * Клас призначений для створення користувача.
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String login;
    private String password;
    private String menu;
    private String role;

    /**
     * Конструктор класу User.class без параметрів.
     *
     * @see User#User(String, String, String, String, String, String, String)
     * @see User#User(String, String, String, String, String, String, String, String)
     */
    public User() {
    }

    /**
     * Конструктор класу User.class з параметрами.
     *
     * @param name      ім'я користувача.
     * @param surname   прізвище користувача.
     * @param telephone телефон користувача.
     * @param email     електронна адреса користувача.
     * @param login     логін користувача.
     * @param password  пароль користувача.
     * @param menu      меню користувача.
     * @param role      роль користувача.
     * @see User#User()
     * @see User#User(String, String, String, String, String, String, String)
     */
    public User(String name, String surname, String telephone, String email, String login, String password, String menu, String role) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.menu = menu;
        this.role = role;
    }

    /**
     * Конструктор класу User.class з параметрами.
     *
     * @param name      ім'я користувача.
     * @param surname   прізвище користувача.
     * @param telephone телефон користувача.
     * @param email     електронна адреса користувача.
     * @param login     логін користувача.
     * @param password  пароль користувача.
     * @param role      роль користувача.
     * @see User#User()
     * @see User#User(String, String, String, String, String, String, String, String)
     */
    public User(String name, String surname, String telephone, String email, String login, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * Створення статичного класу Builder, щоб із об'єкта класу UserDTO.class створювати об'єкта класу User.class
     */
    public static class Builder {
        User user = new User();

        /**
         * Метод призначений для того, щоб записати в поле "name" об'єкту класу User.class значення поля "name" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setName(UserDTO userDTO) {
            user.setName(userDTO.getName());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "surname" об'єкту класу User.class значення поля "surname" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setSurname(UserDTO userDTO) {
            user.setSurname(userDTO.getSurname());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "telephone" об'єкту класу User.class значення поля "telephone" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setTelephone(UserDTO userDTO) {
            user.setTelephone(userDTO.getTelephone());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "email" об'єкту класу User.class значення поля "email" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setEmail(UserDTO userDTO) {
            user.setEmail(userDTO.getEmail());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "login" об'єкту класу User.class значення поля "login" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setLogin(UserDTO userDTO) {
            user.setLogin(userDTO.getLogin());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "password" об'єкту класу User.class значення поля "password" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setPassword(UserDTO userDTO) {
            user.setPassword(userDTO.getPassword());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "menu" об'єкту класу User.class значення поля "menu" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setMenu(UserDTO userDTO) {
            user.setMenu(userDTO.getMenu());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "role" об'єкту класу User.class значення поля "role" об'єкту класу UserDTO.class та вернути ссилку на User.Builder
         *
         * @param userDTO об'єкта класу UserDTO.class
         * @return посилання на User.Builder
         */
        public User.Builder setRole(UserDTO userDTO) {
            user.setRole(userDTO.getRole());
            return this;
        }

        /**
         * Метод призначений для видачі об'єкту класу User.class
         *
         * @return об'єкт класу User.class
         */
        public User build() {
            return user;
        }
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
