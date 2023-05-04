package com.example.gestionstock.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="idproduit")
    private Product product;

    @ManyToOne
    @JoinColumn(name="idcommandefournisseur")
    private CommandeFournisseur commandefournisseur;
}
