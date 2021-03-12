package com.prueba.tecnica.service;

import com.prueba.tecnica.model.LoginRequest;
import com.prueba.tecnica.model.LoginResponse;
import io.reactivex.Single;

public interface LoginService {
    Single<LoginResponse> login(LoginRequest loginRequest);
}

