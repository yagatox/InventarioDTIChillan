package com.example.inventariodtichillan.entities;

import com.google.gson.annotations.SerializedName;

public class ReservasFiltradas {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre_reserva")
    private String nombre_reserva;

    @SerializedName("feha_reserva")
    private String feha_reserva;

    @SerializedName("tiempo_reserva")
    private String tiempo_reserva;

    @SerializedName("nombre_reservante")
    private String nombre_reservante;

    @SerializedName("articulo")
    private int articulo;

    public ReservasFiltradas(int id, String nombre_reserva, String feha_reserva, String tiempo_reserva, String nombre_reservante, int articulo) {
        this.id = id;
        this.nombre_reserva = nombre_reserva;
        this.feha_reserva = feha_reserva;
        this.tiempo_reserva = tiempo_reserva;
        this.nombre_reservante = nombre_reservante;
        this.articulo = articulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_reserva() {
        return nombre_reserva;
    }

    public void setNombre_reserva(String nombre_reserva) {
        this.nombre_reserva = nombre_reserva;
    }

    public String getFeha_reserva() {
        return feha_reserva;
    }

    public void setFeha_reserva(String feha_reserva) {
        this.feha_reserva = feha_reserva;
    }

    public String getTiempo_reserva() {
        return tiempo_reserva;
    }

    public void setTiempo_reserva(String tiempo_reserva) {
        this.tiempo_reserva = tiempo_reserva;
    }

    public String getNombre_reservante() {
        return nombre_reservante;
    }

    public void setNombre_reservante(String nombre_reservante) {
        this.nombre_reservante = nombre_reservante;
    }

    public int getArticulo() {
        return articulo;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
    }
}
