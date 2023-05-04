package com.example.gestionstock.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="mouvementstock")
public class MvtStk extends AbstractEntity{

    private Instant dateMvt;

    private BigDecimal quantite;

    private TypeMvtStk typeMvt;

    @ManyToOne
    @JoinColumn(name="idproduit")
    private Product product;
}
