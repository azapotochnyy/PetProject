package net.goodfoodonly.dto;

import net.goodfoodonly.domains.User;

/**
 * Клас призначений для створення трансферних об'єктів для класу User.class
 *
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class UserDTO {
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
     * Конструктор класу UserDTO.class без параметрів.
     *
     * @see UserDTO#UserDTO(String, String, String, String, String, String, String)
     * @see UserDTO#UserDTO(String, String, String, String, String, String, String, String)
     */
    public UserDTO() {
    }

    /**
     * Конструктор класу UserDTO.class з параметрами.
     *
     * @param name      ім'я користувача.
     * @param surname   прізвище користувача.
     * @param telephone телефон користувача.
     * @param email     електронна адреса користувача.
     * @param login     логін користувача.
     * @param password  пароль користувача.
     * @param menu      меню користувача.
     * @param role      роль користувача.
     * @see UserDTO#UserDTO()
     * @see UserDTO#UserDTO(String, String, String, String, String, String, String)
     */
    public UserDTO(String name, String surname, String telephone, String email, String login, String password, String menu, String role) {
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
     * Конструктор класу UserDTO.class з параметрами.
     *
     * @param name      ім'я користувача.
     * @param surname   прізвище користувача.
     * @param telephone телефон користувача.
     * @param email     електронна адреса користувача.
     * @param login     логін користувача.
     * @param password  пароль користувача.
     * @param role      роль користувача.
     * @see UserDTO#UserDTO()
     * @see UserDTO#UserDTO(String, String, String, String, String, String, String, String)
     */
    public UserDTO(String name, String surname, String telephone, String email, String login, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * Створення статичного класу Builder, щоб із об'єкта класу User.class створювати об'єкта класу UserDTO.class.
     */
    public static class Builder {

        UserDTO userDTO = new UserDTO();

        /**
         * Метод призначений для того, щоб записати в поле "name" об'єкту класу UserDTO.class значення поля "name" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setName(User user) {
            userDTO.setName(user.getName());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "surname" об'єкту класу UserDTO.class значення поля "surname" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setSurname(User user) {
            userDTO.setSurname(user.getSurname());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "telephone" об'єкту класу UserDTO.class значення поля "telephone" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setTelephone(User user) {
            userDTO.setTelephone(user.getTelephone());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "email" об'єкту класу UserDTO.class значення поля "email" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setEmail(User user) {
            userDTO.setEmail(user.getEmail());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "login" об'єкту класу UserDTO.class значення поля "login" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setLogin(User user) {
            userDTO.setLogin(user.getLogin());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "password" об'єкту класу UserDTO.class значення поля "password" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setPassword(User user) {
            userDTO.setPassword(user.getPassword());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "menu" об'єкту класу UserDTO.class значення поля "menu" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setMenu(User user) {
            userDTO.setMenu(user.getMenu());
            return this;
        }

        /**
         * Метод призначений для того, щоб записати в поле "role" об'єкту класу UserDTO.class значення поля "role" об'єкту класу User.class та вернути ссилку на Builder.
         *
         * @param user об'єкта класу User.class.
         * @return посилання на UserDTO.Builder.
         */
        public UserDTO.Builder setRole(User user) {
            userDTO.setRole(user.getRole());
            return this;
        }

        /**
         * Метод призначений для видачі об'єкту класу UserDTO.class
         *
         * @return об'єкт класу UserDTO.class
         */
        public UserDTO build() {
            return userDTO;
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
}
