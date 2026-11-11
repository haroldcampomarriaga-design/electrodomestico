package com.uniremington.electrodomesticos.model.vo;

import java.time.LocalDate;

public class GarantiaVO {

    private Integer idGarantia;
    private Integer idSerie;
    private Integer idDetalleVenta;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String estado;
    private String observaciones;

    public GarantiaVO() {
    }

    public GarantiaVO(Integer idGarantia, Integer idSerie, Integer idDetalleVenta,
                     LocalDate fechaInicio, LocalDate fechaVencimiento,
                     String estado, String observaciones) {
        this.idGarantia = idGarantia;
        this.idSerie = idSerie;
        this.idDetalleVenta = idDetalleVenta;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Integer getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
