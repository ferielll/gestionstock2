package com.example.gestionstock.validators;

import com.example.gestionstock.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if(userDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");

        }

        if(!StringUtils.hasLength(userDto.getNom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if(!StringUtils.hasLength(userDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if(!StringUtils.hasLength(userDto.getMotDePasse())) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if(!StringUtils.hasLength(userDto.getEmail())) {
            errors.add("Veuillez renseigner l'Email d'utilisateur");
        }
        if(userDto.getDateDeNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        if(userDto.getAdresse() == null) {
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        } else {
            if (!StringUtils.hasLength(userDto.getAdresse().getAdresse1())) {
                errors.add("Le champ ' Adresse 1 ' est obligatoire");
            }
            if (!StringUtils.hasLength(userDto.getAdresse().getVille())) {
                errors.add("Le champ ' Ville ' est obligatoire");
            }
            if (!StringUtils.hasLength(userDto.getAdresse().getCodePostal())) {
                errors.add("Le champ ' Code Postal ' est obligatoire");
            }
            if (!StringUtils.hasLength(userDto.getAdresse().getPays())) {
                errors.add("Le champ ' Pays ' est obligatoire");
            }
        }
        return errors;
    }
}
