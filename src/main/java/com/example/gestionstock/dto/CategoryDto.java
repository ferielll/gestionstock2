package com.example.gestionstock.dto;

import com.example.gestionstock.model.Category;
import com.example.gestionstock.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class CategoryDto {

    private Integer id;

    private String code ;

    private String designation;

    @JsonIgnore
    private List<ProductDto> produits;

    public static CategoryDto fromEntity(Category category) {
        if(category == null) {
            // TODO throw an exception
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if(categoryDto == null) {
            // TODO throw an exception
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return category;
    }
}
