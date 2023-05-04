package com.example.gestionstock.dto;

import com.example.gestionstock.model.Adresse;
import com.example.gestionstock.model.Category;
import com.example.gestionstock.model.Entreprise;
import com.example.gestionstock.model.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String numTel;

    private String siteWeb;

    private String email;

    private List<User> userList;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if(entreprise == null) {
            // TODO throw an exception
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .description(entreprise.getDescription())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .codeFiscal(entreprise.getCodeFiscal())
                .siteWeb(entreprise.getSiteWeb())
                .photo(entreprise.getPhoto())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if(entrepriseDto == null) {
            // TODO throw an exception
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setNumTel((entrepriseDto.getNumTel()));
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));

        return entreprise;
    }
}
