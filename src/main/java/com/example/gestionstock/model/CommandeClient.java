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
@Table(name="commandeclient")
public class CommandeClient extends AbstractEntity{

    private String code ;

    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name="idclient")
    private Client client;

    @OneToMany(mappedBy="commandeclient")
    private List<LigneCommandeClient> ligneCommandeClientList;
}
