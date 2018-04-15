package net.goodfoodonly.service;

import net.goodfoodonly.dto.UserDTO;

/**
 * @author A.Zapotochnyy
 * @version 1.0
 */
public interface RegistrationService {

    /**
     * Метод призначений зберігати дані користувача(об'єкта класу UserDTO.class).
     *
     * @param userDTO Об'єкт класу UserDTO.class із полями (name, surname, telephone, email, login, password, role).
     */
    void saveUser(UserDTO userDTO);
}
