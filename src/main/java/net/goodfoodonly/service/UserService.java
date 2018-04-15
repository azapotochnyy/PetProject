package net.goodfoodonly.service;

import net.goodfoodonly.dto.UserDTO;

import java.util.List;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public interface UserService {

    /**
     * Метод призначений для отримання списку і даних всіх користуввачів
     *
     * @return повертає список користувачів (List об'єктів класу UserDTO.class)
     */
    List<UserDTO> getAllUsers();

    /**
     * Метод призначений для видалення користувача
     *
     * @param userDTO об'єкт класу UserDTO.class для видалення
     */
    void deleteUser(UserDTO userDTO);
}
