package com.services;

import com.dtos.VacataireDto;

import java.util.List;

public interface VacataireService {
    /**
     * Save a contractor
     */
    VacataireDto saveVacataire(VacataireDto vacataireDto);

    /**
     * Get a contractor by it's id
     */
    VacataireDto getVacataireById(Long vacataireId);

    /**
     * Delete a contractor by it's id
     */
    boolean deleteVacataire(Long vacataireId);

    /**
     * Get all the contractors
     */
    List<VacataireDto> getAllVacataires();


}
