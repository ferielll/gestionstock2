package com.example.gestionstock.dto;

import com.example.gestionstock.model.Category;
import com.example.gestionstock.model.Roles;
import com.example.gestionstock.model.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class RolesDto {

    private Integer id;

    private String roleName;

    private UserDto user;

    public static RolesDto fromEntity(Roles roles) {
        if(roles == null) {
            // TODO throw an exception
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if(rolesDto == null) {
            // TODO throw an exception
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());

        return roles;
    }
}
