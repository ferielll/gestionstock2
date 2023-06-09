package com.example.gestionstock.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="lignevente")
public class LigneVente extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="idvente")
    private Ventes ventes;

    private BigDecimal quantite;
}
