package com.dtos;

import com.entities.Vacataire;
import lombok.Data;

import java.util.List;

@Data
public class CoursDto {
	
	private Long Id;
	private String intitule;
	private List<Vacataire> vacataires;
}
