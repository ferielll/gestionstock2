package com.example.gestionstock.dto;

import com.example.gestionstock.model.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UserDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public static UserDto fromEntity(User user) {
        if(user == null) {
            // TODO throw an exception
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .adresse(AdresseDto.fromEntity(user.getAdresse()))
                .entreprise(EntrepriseDto.fromEntity(user.getEntreprise()))
                .photo(user.getPhoto())
                .email(user.getEmail())
                .dateDeNaissance(user.getDateDeNaissance())
                .motDePasse(user.getMotDePasse())
                .roles(
                        user.getRoles() != null ?
                                user.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static User toEntity(UserDto userDto) {
        if(userDto == null) {
            // TODO throw an exception
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setAdresse(AdresseDto.toEntity(userDto.getAdresse()));
        user.setPhoto(userDto.getPhoto());
        user.setEmail(userDto.getEmail());
        user.setDateDeNaissance(userDto.getDateDeNaissance());
        user.setMotDePasse(userDto.getMotDePasse());
        user.setEntreprise(EntrepriseDto.toEntity(userDto.getEntreprise()));
        user.setRoles(
                userDto.getRoles() != null ?
                        userDto.getRoles().stream()
                                .map(RolesDto::toEntity)
                                .collect(Collectors.toList()) : null
        );

        return user;
    }
}
