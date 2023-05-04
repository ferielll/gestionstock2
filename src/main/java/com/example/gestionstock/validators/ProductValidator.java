package com.example.gestionstock.validators;

import com.example.gestionstock.dto.ProductDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {

    public static List<String> validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();

        if(!StringUtils.hasLength(productDto.getCodeProduct())) {
            errors.add("Veuillez renseigner le code du produit");
        }

        if(!StringUtils.hasLength(productDto.getDesignation())) {
            errors.add("Veuillez renseigner la designation du produit");
        }
        return errors;
    }
}
