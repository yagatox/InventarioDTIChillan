package com.example.inventariodtichillan.servicios.tipoarticulo;


import com.example.inventariodtichillan.entities.Tipoarticulo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface TipoarticuloServicio {

    @GET("/tipoarticulo/posts")

   // @Headers("authorization: Token 1270579270fb6013798792c37e706caaa7d1d426")
    Call<List<Tipoarticulo>> findAll(@Header("authorization") String authToken);

}
