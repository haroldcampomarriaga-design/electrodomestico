package com.uniremington.electrodomesticos.vo;

import java.time.LocalDateTime;

public class ProveedorVO {

    private Integer idProveedor;
    private String nombreEmpresa;
    private String nit;
    private String representante;
    private String telefono;
    private String correo;
    private String direccion;
    private String ciudad;
    private String estado;
    private LocalDateTime fechaRegistro;

    public ProveedorVO() {
    }

    public ProveedorVO(Integer idProveedor, String nombreEmpresa, String nit, String representante,
                       String telefono, String correo, String direccion, String ciudad,
                       String estado, LocalDateTime fechaRegistro) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.representante = representante;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

