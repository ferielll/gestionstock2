package com.example.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="commandefournisseur")
public class CommandeFournisseur extends AbstractEntity{

    private String code;

    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name="idfournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandefournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurList;
}
