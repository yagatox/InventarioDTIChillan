package com.example.inventariodtichillan.servicios.usuario;

import com.example.inventariodtichillan.entities.Token;
import com.example.inventariodtichillan.entities.Usuario;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserClient {

    @POST("/rest-auth/login/")
    Call<Token> login (@Body Usuario usuario);

}
