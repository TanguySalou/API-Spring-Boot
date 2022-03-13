package com.dtos;

import com.entities.Cours;
import lombok.Data;

@Data
public class VacataireDto extends UtilisateurDto {
    private Cours cours;
}
