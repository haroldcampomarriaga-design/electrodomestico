package com.uniremington.electrodomesticos.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CompraVO {

    private Integer idCompra;
    private String numeroFactura;
    private Integer idProveedor;
    private Integer idUsuario;
    private LocalDateTime fechaCompra;
    private BigDecimal subtotal;
    private BigDecimal impuesto;
    private BigDecimal total;
    private String estado;

    public CompraVO() {
    }

    public CompraVO(Integer idCompra, String numeroFactura, Integer idProveedor, Integer idUsuario,
                    LocalDateTime fechaCompra, BigDecimal subtotal, BigDecimal impuesto,
                    BigDecimal total, String estado) {
        this.idCompra = idCompra;
        this.numeroFactura = numeroFactura;
        this.idProveedor = idProveedor;
        this.idUsuario = idUsuario;
        this.fechaCompra = fechaCompra;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
        this.estado = estado;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

