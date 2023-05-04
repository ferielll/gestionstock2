package com.example.gestionstock.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="category")
public class Category extends AbstractEntity{

    private String code ;

    private String designation;

    @OneToMany(mappedBy = "category")
    private List<Product> produits;
}
