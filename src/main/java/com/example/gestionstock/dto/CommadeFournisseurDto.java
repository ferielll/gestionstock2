package com.example.gestionstock.dto;

import com.example.gestionstock.model.CommandeClient;
import com.example.gestionstock.model.CommandeFournisseur;
import com.example.gestionstock.model.Fournisseur;
import com.example.gestionstock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommadeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurList;

    public static CommadeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if(commandeFournisseur == null) {
            // TODO throw an exception
            return null;
        }

        return CommadeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .build();
    }

    public static CommandeFournisseur toEntity(CommadeFournisseurDto commadeFournisseurDto) {
        if(commadeFournisseurDto == null) {
            // TODO throw an exception
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commadeFournisseurDto.getId());
        commandeFournisseur.setCode(commadeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commadeFournisseurDto.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commadeFournisseurDto.getFournisseur()));

        return commandeFournisseur;
    }
}
