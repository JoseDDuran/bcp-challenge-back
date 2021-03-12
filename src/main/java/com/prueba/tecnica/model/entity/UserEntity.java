package com.prueba.tecnica.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private String id;
    private String email;
    private String name;
    private String password;
}
