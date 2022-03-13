package com.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="user_type")
@Data
public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String login;
	private String motDePasse;
	private String nomUsuel;
	private String prenom;
	private String mail;
	
}
