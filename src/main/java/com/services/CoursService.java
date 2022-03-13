package com.services;

import com.dtos.CoursDto;

import java.util.List;

public interface CoursService {
    /**
     * Save a course
     */
    CoursDto saveCours(CoursDto coursDto);

    /**
     * Get a course by it's id
     */
    CoursDto getCoursById(Long courId);

    /**
     * Delete a course by it's id
     */
    boolean deleteCours(Long courId);

    /**
     * Get all the courses
     */
    List<CoursDto> getAllCours();


}
