package com.example.gestionstock.dto;

import com.example.gestionstock.model.CommandeClient;
import com.example.gestionstock.model.LigneCommandeClient;
import com.example.gestionstock.model.LigneCommandeFournisseur;
import com.example.gestionstock.model.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class LigneCommandeClientDto {

    private Integer id;

    private ProductDto product;

    private CommandeClientDto commandeclient;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if(ligneCommandeClient == null) {
            // TODO throw an exception
            return null;
        }

        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .product(ProductDto.fromEntity(ligneCommandeClient.getProduct()))
                .commandeclient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeclient()))
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if(ligneCommandeClientDto == null) {
            // TODO throw an exception
            return null;
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setProduct(ProductDto.toEntity(ligneCommandeClientDto.getProduct()));
        ligneCommandeClient.setCommandeclient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeclient()));

        return ligneCommandeClient;
    }
}
