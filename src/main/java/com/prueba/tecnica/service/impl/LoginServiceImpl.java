package com.prueba.tecnica.service.impl;


import com.prueba.tecnica.config.ApplicationProperties;
import com.prueba.tecnica.model.*;
import com.prueba.tecnica.model.entity.ExchangeRate;
import com.prueba.tecnica.model.entity.UserEntity;
import com.prueba.tecnica.repository.ExchangeRateRepository;
import com.prueba.tecnica.service.ExchangeRateService;
import com.prueba.tecnica.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final ApplicationProperties applicationProperties;

    @Override
    public Single<LoginResponse> login(LoginRequest loginRequest) {
        return Single.just(UserEntity.builder()
                    .id("1")
                    .email(loginRequest.getEmail())
                    .name("genericuser")
                    .password(loginRequest.getPassword())
                .build())
                .map(this::getToken)
                .map(token -> LoginResponse.builder().token(token).build());
    }

    private String getToken(UserEntity user) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");

        String token = Jwts
                .builder()
                .setId(user.getId())
                .setSubject(user.getName())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .signWith(SignatureAlgorithm.HS512,
                        applicationProperties.getSecretKey().getBytes()).compact();

        return token;
    }
}
