package com.example.gestionstock.dto;

import com.example.gestionstock.model.Adresse;
import com.example.gestionstock.model.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdresseDto {

    private Integer id;

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostal;

    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if(adresse == null) {
            // TODO throw an exception
            return null;
        }

        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostal(adresse.getCodePostal())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if(adresseDto == null) {
            // TODO throw an exception
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2((adresseDto.getAdresse2()));
        adresse.setPays(adresseDto.getPays());
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostal(adresseDto.getCodePostal());

        return adresse;
    }
}
