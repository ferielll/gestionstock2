package com.example.gestionstock.dto;

import com.example.gestionstock.model.LigneVente;
import com.example.gestionstock.model.MvtStk;
import com.example.gestionstock.model.Product;
import com.example.gestionstock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private TypeMvtStk typeMvt;

    private ProductDto product;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if(mvtStk == null) {
            // TODO throw an exception
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .typeMvt(mvtStk.getTypeMvt())
                .product(ProductDto.fromEntity(mvtStk.getProduct()))
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto) {
        if(mvtStkDto == null) {
            // TODO throw an exception
            return null;
        }
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
        mvtStk.setProduct(ProductDto.toEntity(mvtStkDto.getProduct()));
        mvtStk.setQuantite(mvtStkDto.getQuantite());

        return mvtStk;
    }
}
