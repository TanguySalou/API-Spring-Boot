package com.entities;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(name="vacataire")
@Data
public class Vacataire extends Utilisateur{

    @ManyToOne
    private Cours cours;
}
