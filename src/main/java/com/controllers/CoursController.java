package com.controllers;

import com.dtos.CoursDto;
import com.services.impl.CoursServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

	private final CoursServiceImpl coursService;

	public CoursController(CoursServiceImpl coursService) {
		this.coursService = coursService;
	}

	/**
	 * <p>Get all cours in the system</p>
	 * @return List<CoursDto>
	 */
	@GetMapping
	public List<CoursDto> getCours() {
		return coursService.getAllCours();
	}

	/**
	 * Method to get the user based on the ID
	 */
	@GetMapping("/{id}")
	public CoursDto getCour(@PathVariable Long id){
		return coursService.getCoursById(id);
	}

	/**
	 * Create a new Cours in the system
	 */
	@PostMapping
	public CoursDto saveCour(final @RequestBody CoursDto coursDto){
		return coursService.saveCours(coursDto);
	}

	/**
	 * Delete a cours by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteCours(@PathVariable Long id){
		return coursService.deleteCours(id);
	}
	
}
