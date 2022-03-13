package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cours {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String intitule;

	@ManyToMany
	private List<Vacataire> vacataires;

}
