package com.StartupsBootcamp.Startups.Entidades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_proyecto;

    @Column(unique = true,nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private  EstadoProyecto estado;

    @Enumerated(EnumType.STRING)
    private CategoriaProyecto categoria;

    @Column(columnDefinition = "DATE")
    private Date fecha_inicio;

    @Enumerated(EnumType.STRING)
    private Ubicacion ubicacion;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name="Usuario")
    @JsonIgnore
    private Usuario usuario;

    public Proyecto() {
    }


    public Proyecto(int id_proyecto, String nombre, String descripcion, EstadoProyecto estado,
            CategoriaProyecto categoria, Date fecha_inicio, Ubicacion ubicacion, Usuario usuario) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoria = categoria;
        this.fecha_inicio = fecha_inicio;
        this.ubicacion=ubicacion;
        this.usuario=usuario;
    }


    public int getId_proyecto() {
        return id_proyecto;
    }


    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public EstadoProyecto getEstado() {
        return estado;
    }


    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }


    public CategoriaProyecto getCategoria() {
        return categoria;
    }


    public void setCategoria(CategoriaProyecto categoria) {
        this.categoria = categoria;
    }


    public Date getFecha_inicio() {
        return fecha_inicio;
    }


    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


    public Ubicacion getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
