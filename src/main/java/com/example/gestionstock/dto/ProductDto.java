package com.example.gestionstock.dto;

import com.example.gestionstock.model.Category;
import com.example.gestionstock.model.Client;
import com.example.gestionstock.model.Product;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Builder
@Data
public class ProductDto {

    private Integer id;

    private String codeProduct;

    private String designation;

    private String photo;

    private BigDecimal prixUnitaireHt;

    private BigDecimal prixUnitaireTtc;

    private BigDecimal tauxTva;

    private CategoryDto category;

    public static ProductDto fromEntity(Product product) {
        if(product == null) {
            // TODO throw an exception
            return null;
        }

        return ProductDto.builder()
                .id(product.getId())
                .designation(product.getDesignation())
                .codeProduct(product.getCodeProduct())
                .photo(product.getPhoto())
                .prixUnitaireHt(product.getPrixUnitaireHt())
                .prixUnitaireTtc(product.getPrixUnitaireTtc())
                .tauxTva(product.getTauxTva())
                .category(CategoryDto.fromEntity(product.getCategory()))
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        if(productDto == null) {
            // TODO throw an exception
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCodeProduct(productDto.getCodeProduct());
        product.setDesignation(productDto.getDesignation());
        product.setCategory(CategoryDto.toEntity(productDto.getCategory()));
        product.setPhoto(productDto.getPhoto());
        product.setTauxTva(productDto.getTauxTva());
        product.setPrixUnitaireHt(productDto.getPrixUnitaireHt());
        product.setPrixUnitaireTtc(productDto.getPrixUnitaireTtc());

        return product;
    }
}
