package com.uniremington.electrodomesticos.model.vo;

import java.time.LocalDateTime;

public class DevolucionVO {

    private Integer idDevolucion;
    private String tipoDevolucion;
    private Integer idVenta;
    private Integer idCompra;
    private Integer idUsuario;
    private LocalDateTime fechaDevolucion;
    private String motivo;
    private String estado;
    private String observaciones;

    public DevolucionVO() {
    }

    public DevolucionVO(Integer idDevolucion, String tipoDevolucion, Integer idVenta,
                        Integer idCompra, Integer idUsuario, LocalDateTime fechaDevolucion,
                        String motivo, String estado, String observaciones) {
        this.idDevolucion = idDevolucion;
        this.tipoDevolucion = tipoDevolucion;
        this.idVenta = idVenta;
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.fechaDevolucion = fechaDevolucion;
        this.motivo = motivo;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public String getTipoDevolucion() {
        return tipoDevolucion;
    }

    public void setTipoDevolucion(String tipoDevolucion) {
        this.tipoDevolucion = tipoDevolucion;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
