package com.StartupsBootcamp.Startups.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StartupsBootcamp.Startups.Entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByDocumento(String documento);
}
