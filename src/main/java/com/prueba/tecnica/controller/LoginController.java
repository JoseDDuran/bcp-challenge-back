package com.prueba.tecnica.controller;


import com.prueba.tecnica.model.LoginRequest;
import com.prueba.tecnica.model.LoginResponse;
import com.prueba.tecnica.service.LoginService;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("login")
    public Single<LoginResponse> login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
