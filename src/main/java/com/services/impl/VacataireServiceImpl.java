package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {

	private final VacataireRepository vacataireRepository;

    public VacataireServiceImpl(VacataireRepository vacataireRepository) {
        this.vacataireRepository = vacataireRepository;
    }

    @Override
    public VacataireDto saveVacataire(VacataireDto vacataireDto) {
        // Converts the dto to the user entity
        Vacataire vacataire = vacataireDtoToEntity(vacataireDto);
        // Save the user entity
        vacataire = vacataireRepository.save(vacataire);
        // Return the new dto
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public VacataireDto getVacataireById(Long vacataireId) {
        Vacataire vacataire = vacataireRepository.findById(vacataireId).orElseThrow(() -> new EntityNotFoundException("Vacataire not found"));
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public boolean deleteVacataire(Long vacataireId) {
        vacataireRepository.deleteById(vacataireId);
        return true;
    }

    @Override
    public List<VacataireDto> getAllVacataires() {
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = vacataireRepository.findAll();
        vacataires.forEach(vacataire -> vacataireDtos.add(vacataireEntityToDto(vacataire)));
        return vacataireDtos;
    }

    /**
     * Map vacataire dto to vacataire entity
     */
    private VacataireDto vacataireEntityToDto(Vacataire vacataire){
        VacataireDto vacataireDto = new VacataireDto();
        vacataireDto.setId(vacataire.getId());
        vacataireDto.setLogin(vacataire.getLogin());
        vacataireDto.setMotDePasse(vacataire.getMotDePasse());
        vacataireDto.setNomUsuel(vacataire.getNomUsuel());
        vacataireDto.setPrenom(vacataire.getPrenom());
        vacataireDto.setMail(vacataire.getMail());
        vacataireDto.setCours(vacataire.getCours());
        return vacataireDto;
    }

    /**
     * Map vacataire entity to vacataire dto
     */
    private Vacataire vacataireDtoToEntity(VacataireDto vacataireDto){
        Vacataire vacataire = new Vacataire();
        vacataire.setId(vacataireDto.getId());
        vacataire.setLogin(vacataireDto.getLogin());
        vacataire.setMotDePasse(vacataireDto.getMotDePasse());
        vacataire.setNomUsuel(vacataireDto.getNomUsuel());
        vacataire.setPrenom(vacataireDto.getPrenom());
        vacataire.setMail(vacataireDto.getMail());
        vacataire.setCours(vacataireDto.getCours());
        return vacataire;
    }
}
