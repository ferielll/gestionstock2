package com.example.gestionstock.dto;

import com.example.gestionstock.model.Category;
import com.example.gestionstock.model.LigneVente;
import com.example.gestionstock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VentesDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private List<LigneVenteDto> venteList;

    public static VentesDto fromEntity(Ventes ventes) {
        if(ventes == null) {
            // TODO throw an exception
            return null;
        }

        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public static Ventes toEntity(VentesDto ventesDto) {
        if(ventesDto == null) {
            // TODO throw an exception
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCode(ventesDto.getCode());
        ventes.setCommentaire(ventesDto.commentaire);

        return ventes;
    }

}
