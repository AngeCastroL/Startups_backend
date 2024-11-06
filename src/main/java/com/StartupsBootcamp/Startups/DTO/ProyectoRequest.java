package com.StartupsBootcamp.Startups.DTO;

import com.StartupsBootcamp.Startups.Entidades.Proyecto;

public class ProyectoRequest {
    private String usuarioId;
    private Proyecto proyecto;

    public String getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId){
        this.usuarioId=usuarioId;
    }

    public Proyecto getProyecto(){
        return proyecto;
    }
    public void setProyecto(Proyecto proyecto){
        this.proyecto=proyecto;
    }
}
