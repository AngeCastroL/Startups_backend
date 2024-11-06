package com.StartupsBootcamp.Startups.Servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.StartupsBootcamp.Startups.Entidades.Usuario;
import com.StartupsBootcamp.Startups.Repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario CrearUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> getUsuarioById(String documento){
        return usuarioRepositorio.findByDocumento(documento);
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepositorio.findAll();
    }

}
