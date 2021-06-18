package com.example.inventariodtichillan.entities;

import com.google.gson.annotations.SerializedName;

public class Articulo {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("valor")
    private String valor;

    @SerializedName("cantidad")
    private String cantidad;

    @SerializedName("caracteristicas")
    private String caracteristicas;

    @SerializedName("estado")
    private String estado;

    @SerializedName("color")
    private String color;

    @SerializedName("fecha_compra")
    private String fecha_compra;

    @SerializedName("numero_orden_compra")
    private int numero_orden_compra;

    @SerializedName("marca")
    private String marca;

    @SerializedName("stock_actual")
    private int stock_actual;

    @SerializedName("stock_minimo")
    private int stock_minimo;

    @SerializedName("modelo")
    private String modelo;

    @SerializedName("proveedor")
    private String proveedor;

    @SerializedName("qr_code")
    private String qr_code;

    @SerializedName("ultimo_precio_compra")
    private int ultimo_precio_compra;

    @SerializedName("estado_reserva")
    private String estado_reserva;

    @SerializedName("numero_de_serie")
    private int numero_de_serie;

    @SerializedName("fecha_creacion_QR")
    private String fecha_creacion_QR;

    @SerializedName("tipo")
    private int tipo;

    @SerializedName("seccion")
    private int seccion;

    //get y set abajo

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getNumero_orden_compra() {
        return numero_orden_compra;
    }

    public void setNumero_orden_compra(int numero_orden_compra) {
        this.numero_orden_compra = numero_orden_compra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public int getUltimo_precio_compra() {
        return ultimo_precio_compra;
    }

    public void setUltimo_precio_compra(int ultimo_precio_compra) {
        this.ultimo_precio_compra = ultimo_precio_compra;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public int getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(int numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }

    public String getFecha_creacion_QR() {
        return fecha_creacion_QR;
    }

    public void setFecha_creacion_QR(String fecha_creacion_QR) {
        this.fecha_creacion_QR = fecha_creacion_QR;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }
}
