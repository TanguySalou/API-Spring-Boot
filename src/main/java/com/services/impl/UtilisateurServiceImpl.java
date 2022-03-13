package com.services.impl;

import com.dtos.UtilisateurDto;
import com.entities.Utilisateur;
import com.repositories.UtilisateurRepository;
import com.services.UtilisateurService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

	private final UtilisateurRepository userRepository;

    public UtilisateurServiceImpl(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UtilisateurDto saveUser(UtilisateurDto userDto) {
        // Converts the dto to the user entity
        Utilisateur user = userDtoToEntity(userDto);
        // Save the user entity
        user = userRepository.save(user);
        // Return the new dto
        return userEntityToDto(user);
    }

    @Override
    public UtilisateurDto getUserById(Long userId) {
        Utilisateur user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userEntityToDto(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public List<UtilisateurDto> getAllUsers() {
        List<UtilisateurDto> userDtos = new ArrayList<>();
        List<Utilisateur> users = userRepository.findAll();
        users.forEach(user -> userDtos.add(userEntityToDto(user)));
        return userDtos;
    }

    /**
     * Map user dto to user entity
     */
    private UtilisateurDto userEntityToDto(Utilisateur user){
        UtilisateurDto userDto = new UtilisateurDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setMotDePasse(user.getMotDePasse());
        userDto.setNomUsuel(user.getNomUsuel());
        userDto.setPrenom(user.getPrenom());
        userDto.setMail(user.getMail());
        return userDto;
    }

    /**
     * Map user entity to user dto
     */
    private Utilisateur userDtoToEntity(UtilisateurDto userDto){
        Utilisateur user = new Utilisateur();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setMotDePasse(userDto.getMotDePasse());
        user.setNomUsuel(userDto.getNomUsuel());
        user.setPrenom(userDto.getPrenom());
        user.setMail(userDto.getMail());
        return user;
    }
}
