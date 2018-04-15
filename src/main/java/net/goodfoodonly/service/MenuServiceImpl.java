package net.goodfoodonly.service;

import net.goodfoodonly.dao.DaoFactory;
import net.goodfoodonly.dao.MenuDao;
import net.goodfoodonly.dao.utils.TransactionHelper;
import net.goodfoodonly.dao.utils.exceptions.*;
import net.goodfoodonly.dao.utils.exceptions.menu.MenuAlreadyExistException;
import net.goodfoodonly.dao.utils.exceptions.menu.MenuDaoException;
import net.goodfoodonly.dao.utils.exceptions.menu.MenuExistException;
import net.goodfoodonly.dao.utils.exceptions.user.DaoException;
import net.goodfoodonly.domains.Menu;
import net.goodfoodonly.dto.MenuDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public class MenuServiceImpl implements MenuService {

    /**
     * Метод призначений для збереження об'єкта класу MenuDTO.class, що передається в параметр.
     *
     * @param menuDTO Об'єкт класу MenuDTO.class із заповненими полями (name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     * @see net.goodfoodonly.dao.MenuDao#saveMenu(Menu)
     */
    @Override
    public void saveMenu(MenuDTO menuDTO) {
        try {
            TransactionHelper.getInstance().beginTransaction();
            Menu menu = new Menu.Builder()
                    .setName(menuDTO)
                    .setBreakfast(menuDTO)
                    .setLunchOne(menuDTO)
                    .setDinner(menuDTO)
                    .setLunchTwo(menuDTO)
                    .setSupper(menuDTO)
                    .setLunchThree(menuDTO)
                    .setDate(menuDTO)
                    .build();
            DaoFactory.getInstance().getMenuDao().saveMenu(menu);
            TransactionHelper.getInstance().commit();
        } catch (DaoException ex) {
            TransactionHelper.getInstance().rollback();
            throw new ServiceException(ex);
        } catch (MenuAlreadyExistException ex) {
            TransactionHelper.getInstance().rollback();
            throw new MenuExistException(ex);
        }
    }

    /**
     * Метод призначений видати меню для користувача на певну дату.
     *
     * @param login логін користувача для якого потрібно отримати меню.
     * @param date  дата на яку необхідно отримати меню.
     * @return об'єкт класу MenuDTO.class із заповненими полями (name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     * @see net.goodfoodonly.dao.MenuDao#getMenuByDate(String, String)
     */
    @Override
    public MenuDTO getMenuByDate(String login, String date) {
        MenuDTO menuDto = null;
        try {
            Menu menu = DaoFactory.getInstance().getMenuDao().getMenuByDate(login, date);
            if (menu != null) {
                menuDto = new MenuDTO.Builder()
                        .setName(menu)
                        .setBreakfast(menu)
                        .setLunchOne(menu)
                        .setDinner(menu)
                        .setLunchTwo(menu)
                        .setSupper(menu)
                        .setLunchThree(menu)
                        .setDate(menu).build();
            }
        } catch (MenuDaoException ex) {
            return menuDto;
        }
        return menuDto;
    }

    /**
     * Метод призначений для того щоб видати меню на певну дату.
     *
     * @param menuname меню яке потрібно переглянути.
     * @param date     дата на яку потрібно отримати меню.
     * @return об'єкт класу MenuDTO.class із заповненими полями (name, breakfast, lunchOne, dinner, lunchTwo, supper, lunchThree, date).
     * @see net.goodfoodonly.dao.MenuDao#getAllMenuByDate(String, String)
     */
    @Override
    public MenuDTO getAllMenuByDate(String menuname, String date) {
        MenuDTO menuDto = null;
        try {
            Menu menu = DaoFactory.getInstance().getMenuDao().getAllMenuByDate(menuname, date);
            if (menu != null) {
                menuDto = new MenuDTO();
                menuDto.setName(menu.getName());
                menuDto.setBreakfast(menu.getBreakfast());
                menuDto.setLunchOne(menu.getLunchOne());
                menuDto.setDinner(menu.getDinner());
                menuDto.setLunchTwo(menu.getLunchTwo());
                menuDto.setSupper(menu.getSupper());
                menuDto.setLunchThree(menu.getLunchThree());
                menuDto.setDate(menu.getDate());
            }
        } catch (MenuDaoException ex) {
            return menuDto;
        }
        return menuDto;
    }

    /**
     * Метод призначений для того щоб видати список доступних дат для вибраного меню.
     *
     * @param menuname меню для якого потрібно отримати список доступних дат.
     * @return повертає список дат доступних для вибраного меню.
     * @see net.goodfoodonly.dao.MenuDao#getDateList(String)
     */
    @Override
    public List<MenuDTO> getDateList(String menuname) {
        List<MenuDTO> menuDtoList = new ArrayList<>();
        try {
            List<Menu> menulist = DaoFactory.getInstance().getMenuDao().getDateList(menuname);
            for (int i = 0; i < menulist.size(); i++) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setDate(menulist.get(i).getDate());
                menuDtoList.add(menuDTO);
            }
        } catch (MenuDaoException ex) {
            return menuDtoList;
        }
        return menuDtoList;
    }

    /**
     * Метод призначений для показу імені поточного меню, яке назначене користувачу.
     *
     * @param login логін користувача для якого потрібно отримати ім'я назначеного меню.
     * @return ім'я меню, яке назначене користувачу.
     * @see net.goodfoodonly.dao.MenuDao#getMenuNameByLogin(String)
     */
    @Override
    public String getMenuNameByLogin(String login) {
        return DaoFactory.getInstance().getMenuDao().getMenuNameByLogin(login);
    }

    /**
     * Метод призначений для призначення меню користувачу.
     *
     * @param login    логін користувача для якого потрібно назначити меню.
     * @param menuname ім'я меню яке назначається юзеру.
     * @see net.goodfoodonly.dao.MenuDao#setUpdateMenu(String, String)
     */
    @Override
    public void updateMenu(String login, String menuname) {
        try {
            DaoFactory.getInstance().getMenuDao().setUpdateMenu(login, menuname);
        } catch (MenuDaoException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод призначений для отримання списка імен меню.
     *
     * @return Список із об'єктів класу MenuDTO.class із заповненим полем name
     * @see MenuDao#getAllMenusNames()
     */
    @Override
    public List<MenuDTO> getAllMenusNames() {
        List<MenuDTO> menuDtoList = new ArrayList<>();
        try {
            List<Menu> menulist = DaoFactory.getInstance().getMenuDao().getAllMenusNames();
            for (int i = 0; i < menulist.size(); i++) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setName(menulist.get(i).getName());
                menuDtoList.add(menuDTO);
            }
        } catch (MenuDaoException ex) {
            return menuDtoList;
        }
        return menuDtoList;
    }

    /**
     * Метод призначений для видалення меню із БД.
     *
     * @param menuDTO меню Об'єкт класу MenuDTO.class що планується видалити із БД
     * @see MenuDao#deleteMenu(Menu)
     */
    @Override
    public void deleteMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setName(menuDTO.getName());
        try {
            TransactionHelper.getInstance().beginTransaction();
            DaoFactory.getInstance().getMenuDao().deleteMenu(menu);
            TransactionHelper.getInstance().commit();
        } catch (MenuDaoException ex) {
            TransactionHelper.getInstance().rollback();
            throw new ServiceException(ex);
        }
    }

    /**
     * Метод призначений для видалення меню на певну дату.
     *
     * @param menuDTO об'єкт класу MenuDTO.class із заповненими полями "name" та "date". Тобто ім'я меню і дату на яку потрібно його видалити.
     * @see MenuDao#deleteMenuByDate(Menu)
     */
    @Override
    public void deleteMenuByDate(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setDate(menuDTO.getDate());
        menu.setName(menuDTO.getName());
        try {
            TransactionHelper.getInstance().beginTransaction();
            DaoFactory.getInstance().getMenuDao().deleteMenuByDate(menu);
            TransactionHelper.getInstance().commit();

        } catch (MenuDaoException ex) {
            TransactionHelper.getInstance().rollback();
            throw new ServiceException(ex);
        }
    }
}
