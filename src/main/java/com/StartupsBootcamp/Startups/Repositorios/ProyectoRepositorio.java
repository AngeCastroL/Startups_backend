package com.StartupsBootcamp.Startups.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.StartupsBootcamp.Startups.Entidades.Proyecto;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto, Integer>{
    List<Proyecto> findByUsuario_Documento(String usuarioId);
    /*
    @Query("SELECT p FROM Proyecto  JOIN FETCH p.usuario")*/

}
