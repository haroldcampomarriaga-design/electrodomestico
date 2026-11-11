package com.uniremington.electrodomesticos.model.vo;

public class DetalleDevolucionVO {

    private Integer idDetalleDevolucion;
    private Integer idDevolucion;
    private Integer idProducto;
    private Integer idDetalleVenta;
    private Integer idDetalleCompra;
    private Integer cantidad;
    private String estadoProducto;
    private String accion;

    public DetalleDevolucionVO() {
    }

    public DetalleDevolucionVO(Integer idDetalleDevolucion, Integer idDevolucion, Integer idProducto,
                              Integer idDetalleVenta, Integer idDetalleCompra, Integer cantidad,
                              String estadoProducto,
                              String accion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
        this.idDevolucion = idDevolucion;
        this.idProducto = idProducto;
        this.idDetalleVenta = idDetalleVenta;
        this.idDetalleCompra = idDetalleCompra;
        this.cantidad = cantidad;
        this.estadoProducto = estadoProducto;
        this.accion = accion;
    }

    public Integer getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
