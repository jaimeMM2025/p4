package com.jaime.practica4_api_rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private Double precioCierre;
    private Long volumen;

    public Accion() {
    }

    public Accion(LocalDate fecha, Double precioCierre, Long volumen) {
        this.fecha = fecha;
        this.precioCierre = precioCierre;
        this.volumen = volumen;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getPrecioCierre() {
        return precioCierre;
    }

    public Long getVolumen() {
        return volumen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPrecioCierre(Double precioCierre) {
        this.precioCierre = precioCierre;
    }

    public void setVolumen(Long volumen) {
        this.volumen = volumen;
    }
}
