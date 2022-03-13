package com.services;

import com.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     * Save a user
     */
    UtilisateurDto saveUser(UtilisateurDto userDto);

    /**
     * Get a user by it's id
     */
    UtilisateurDto getUserById(Long userId);

    /**
     * Delete a user by it's id
     */
    boolean deleteUser(Long userId);

    /**
     * Get all the users
     */
    List<UtilisateurDto> getAllUsers();


}
