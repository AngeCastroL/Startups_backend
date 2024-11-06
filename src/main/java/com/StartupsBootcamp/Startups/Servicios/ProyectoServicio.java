package com.StartupsBootcamp.Startups.Servicios;

import com.StartupsBootcamp.Startups.Entidades.Proyecto;
import com.StartupsBootcamp.Startups.Entidades.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StartupsBootcamp.Startups.Repositorios.ProyectoRepositorio;

@Service
public class ProyectoServicio {

    @Autowired
    private ProyectoRepositorio proyectoRepositorio;


    
    public Proyecto crearProyecto(Proyecto proyecto, Optional<Usuario> usuario) {
        usuario.ifPresent(proyecto::setUsuario);
        return proyectoRepositorio.save(proyecto);
    }

    public List<Proyecto> getAllProyectos(){
        return proyectoRepositorio.findAll();
    }

    
    public List<Proyecto> getAllProyectosWithUsuario(String usuarioId){
        return proyectoRepositorio.findByUsuario_Documento(usuarioId);
    }

    public void deleteProyecto(Integer id_proyecto){
        proyectoRepositorio.deleteById(id_proyecto);
    }

    
    // Method to update a Proyecto by ID
    public Proyecto updateProyectoById(Integer id_proyecto, Proyecto updatedProyecto) {
        // Check if the Proyecto exists
        return proyectoRepositorio.findById(id_proyecto).map(existingProyecto -> {
            // Update fields
            if (updatedProyecto.getNombre() != null) {
                existingProyecto.setNombre(updatedProyecto.getNombre());
            }
            if (updatedProyecto.getDescripcion() != null) {
                existingProyecto.setDescripcion(updatedProyecto.getDescripcion());
            }
            if (updatedProyecto.getEstado() != null) {
                existingProyecto.setEstado(updatedProyecto.getEstado());
            }
            if (updatedProyecto.getCategoria() != null) {
                existingProyecto.setCategoria(updatedProyecto.getCategoria());
            }
            if (updatedProyecto.getFecha_inicio() != null) {
                existingProyecto.setFecha_inicio(updatedProyecto.getFecha_inicio());
            }
            if (updatedProyecto.getUbicacion() != null) {
                existingProyecto.setUbicacion(updatedProyecto.getUbicacion());
            }

            // Save the updated Proyecto
            return proyectoRepositorio.save(existingProyecto);
        }).orElseThrow(() -> new RuntimeException("Proyecto with ID " + id_proyecto + " not found"));
    } 
}
