package com.StartupsBootcamp.Startups.Controladores;


import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StartupsBootcamp.Startups.Entidades.Login;
import com.StartupsBootcamp.Startups.Entidades.Usuario;
import com.StartupsBootcamp.Startups.Servicios.UsuarioServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")

public class UsuarioControlador {

    @Autowired 
    private UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario saveUsuario=usuarioServicio.CrearUsuario(usuario);
        return new ResponseEntity<>(saveUsuario,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<Usuario>> getAllUsuarios(){
        List<Usuario> usuario= usuarioServicio.getAllUsuarios();
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String documento) {
        Optional<Usuario> usuario = usuarioServicio.getUsuarioById(documento);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Login Login) {
        Optional<Usuario> usuarioOpt = usuarioServicio.getUsuarioById(Login.getDocumento());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getContrasenia().equals(Login.getContrasenia())) {
                Usuario userResponse = new Usuario(usuario.getDocumento(), usuario.getNombre(), 
                                                    usuario.getApellido(), usuario.getTipo_documento(),
                                                    usuario.getUsuario(), null, // No incluir la contraseña
                                                    usuario.getCorreo(), usuario.getTelefono(),
                                                    usuario.getFecha_nacimiento());
                return ResponseEntity.ok(userResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}
