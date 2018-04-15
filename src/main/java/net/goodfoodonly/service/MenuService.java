package net.goodfoodonly.service;


import net.goodfoodonly.dto.MenuDTO;

import java.util.List;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public interface MenuService {

    /**
     * Метод призначений для збереження об'єкта класу MenuDTO.class, що передається в параметр.
     *
     * @param menuDTO Об'єкт класу MenuDTO.class із заповненими полями (name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     */
    void saveMenu(MenuDTO menuDTO);

    /**
     * Метод призначений видати меню для користувача на певну дату
     *
     * @param login логін користувача для якого потрібно отримати меню.
     * @param date  дата на яку необхідно отримати меню.
     * @return об'єкт класу MenuDTO.class із заповненими полями (name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     */
    MenuDTO getMenuByDate(String login, String date);

    /**
     * Метод призначений для призначення меню користувачу.
     *
     * @param login    логін користувача для якого потрібно назначити меню.
     * @param menuname ім'я меню яке назначається юзеру.
     */
    void updateMenu(String login, String menuname);

    /**
     * Метод призначений для отримання списка імен меню.
     *
     * @return Список із об'єктів класу MenuDTO.class із заповненим полем name
     */
    List<MenuDTO> getAllMenusNames();

    /**
     * Метод призначений для видалення меню із БД.
     *
     * @param menuDTO меню Об'єкт класу MenuDTO.class що планується видалити із БД
     */
    void deleteMenu(MenuDTO menuDTO);

    /**
     * Метод призначений для того щоб видати текст меню на певну дату
     *
     * @param menuname меню яке потрібно переглянути.
     * @param date     дата на яку потрібно отримати меню.
     * @return об'єкт класу MenuDTO.class із заповненими полями (name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     */
    MenuDTO getAllMenuByDate(String menuname, String date);

    /**
     * Метод призначений для того щоб видати список доступних дат для вибраного меню.
     *
     * @param menuname меню для якого потрібно отримати список доступних дат.
     * @return повертає список дат доступних для вибраного меню.
     */
    List<MenuDTO> getDateList(String menuname);

    /**
     * Метод призначений для показу імені поточного меню, яке назначене користувачу.
     *
     * @param login логін користувача для якого потрібно отримати ім'я назначеного меню
     * @return ім'я меню, яке назначене користувачу
     */
    String getMenuNameByLogin(String login);

    /**
     * Метод призначений для видалення меню на певну дату.
     *
     * @param menuDTO об'єкт класу MenuDTO.class із заповненими полями "name" та "date".
     *                Тобто ім'я меню і дату на яку потрібно його видалити.
     */
    void deleteMenuByDate(MenuDTO menuDTO);
}
