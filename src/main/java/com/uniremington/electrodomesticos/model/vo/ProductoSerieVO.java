package com.uniremington.electrodomesticos.vo;

import java.time.LocalDateTime;

public class ProductoSerieVO {

    private Integer idSerie;
    private Integer idProducto;
    private String numeroSerie;
    private String estado;
    private LocalDateTime fechaRegistro;

    public ProductoSerieVO() {
    }

    public ProductoSerieVO(Integer idSerie, Integer idProducto, String numeroSerie,
                          String estado, LocalDateTime fechaRegistro) {
        this.idSerie = idSerie;
        this.idProducto = idProducto;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

