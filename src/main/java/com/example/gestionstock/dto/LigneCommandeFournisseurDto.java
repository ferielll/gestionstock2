package com.example.gestionstock.dto;

import com.example.gestionstock.model.Category;
import com.example.gestionstock.model.CommandeFournisseur;
import com.example.gestionstock.model.LigneCommandeFournisseur;
import com.example.gestionstock.model.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class LigneCommandeFournisseurDto {

    private Integer id;

    private ProductDto product;

    private CommadeFournisseurDto commandefournisseur;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if(ligneCommandeFournisseur == null) {
            // TODO throw an exception
            return null;
        }

        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .product(ProductDto.fromEntity(ligneCommandeFournisseur.getProduct()))
                .commandefournisseur(CommadeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandefournisseur()))
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if(ligneCommandeFournisseurDto == null) {
            // TODO throw an exception
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setProduct(ProductDto.toEntity(ligneCommandeFournisseurDto.getProduct()));
        ligneCommandeFournisseur.setCommandefournisseur(CommadeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandefournisseur()));

        return ligneCommandeFournisseur;
    }
}
