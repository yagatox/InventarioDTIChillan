package com.example.inventariodtichillan.entities;

import com.google.gson.annotations.SerializedName;

public class Tipoarticulo {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
