package com.services.impl;

import com.dtos.CoursDto;
import com.entities.Cours;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("coursService")
public class CoursServiceImpl implements CoursService {

	private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public CoursDto saveCours(CoursDto coursDto) {
        // Converts the dto to the user entity
        Cours cours = courDtoToEntity(coursDto);
        // Save the user entity
        cours = coursRepository.save(cours);
        // Return the new dto
        return courEntityToDto(cours);
    }

    @Override
    public CoursDto getCoursById(Long coursId) {
        Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new EntityNotFoundException("Cours not found"));
        return courEntityToDto(cours);
    }

    @Override
    public boolean deleteCours(Long coursId) {
        coursRepository.deleteById(coursId);
        return true;
    }

    @Override
    public List<CoursDto> getAllCours() {
        List<CoursDto> coursDtos = new ArrayList<>();
        List<Cours> cours = coursRepository.findAll();
        cours.forEach(cour -> coursDtos.add(courEntityToDto(cour)));
        return coursDtos;
    }

    /**
     * Map cours dto to cours entity
     */
    private CoursDto courEntityToDto(Cours cour){
        CoursDto coursDto = new CoursDto();
        coursDto.setId(cour.getId());
        coursDto.setIntitule(cour.getIntitule());
        coursDto.setVacataires(cour.getVacataires());
        return coursDto;
    }

    /**
     * Map cours entity to cours dto
     */
    private Cours courDtoToEntity(CoursDto courDto){
        Cours cour = new Cours();
        cour.setId(courDto.getId());
        cour.setIntitule(courDto.getIntitule());
        cour.setVacataires(courDto.getVacataires());
        return cour;
    }
}
