package com.controllers;

import com.dtos.UtilisateurDto;
import com.services.impl.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UtilisateurController {

	private final UtilisateurServiceImpl userService;

	public UtilisateurController(UtilisateurServiceImpl userService) {
		this.userService = userService;
	}


	/**
	 * <p>Get all users in the system</p>
	 * @return List<UtilisateurDto>
	 */
	@GetMapping
	public List<UtilisateurDto> getUsers() {
		return userService.getAllUsers();
	}

	/**
	 * Method to get the user based on the ID
	 */
	@GetMapping("/{id}")
	public UtilisateurDto getUser(@PathVariable Long id){
		return userService.getUserById(id);
	}

	/**
	 * Create a new User in the system
	 */
	@PostMapping
	public UtilisateurDto saveUser(final @RequestBody UtilisateurDto userDto){
		return userService.saveUser(userDto);
	}

	/**
	 * Delete a user by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteUser(@PathVariable Long id){
		return userService.deleteUser(id);
	}
	
}
