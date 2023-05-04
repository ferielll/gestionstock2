package com.example.gestionstock.dto;

import com.example.gestionstock.model.LigneCommandeClient;
import com.example.gestionstock.model.LigneVente;
import com.example.gestionstock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {

    private Integer id;

    private VentesDto ventes;

    private BigDecimal quantite;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if(ligneVente == null) {
            // TODO throw an exception
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .ventes(VentesDto.fromEntity(ligneVente.getVentes()))
                .quantite(ligneVente.getQuantite())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if(ligneVenteDto == null) {
            // TODO throw an exception
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setVentes(VentesDto.toEntity(ligneVenteDto.getVentes()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());

        return ligneVente;
    }
}
