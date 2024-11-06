package com.StartupsBootcamp.Startups.Controladores;
import com.StartupsBootcamp.Startups.DTO.ProyectoRequest;
import com.StartupsBootcamp.Startups.Entidades.Proyecto;
import com.StartupsBootcamp.Startups.Entidades.Usuario;
import com.StartupsBootcamp.Startups.Servicios.ProyectoServicio;
import com.StartupsBootcamp.Startups.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proyecto")
public class ProyectoControlador {

    @Autowired
    private ProyectoServicio proyectoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    /*
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        Proyecto saveProyecto = proyectoServicio.crearProyecto(proyecto);
        return new ResponseEntity<>(saveProyecto,HttpStatus.CREATED);
    } 

    
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        String usuarioId = proyecto.getUsuario().getDocumento();
        Optional<Usuario> usuario = usuarioServicio.getUsuarioById(usuarioId);
        Proyecto saveProyecto = proyectoServicio.crearProyecto(proyecto,usuario);
        return new ResponseEntity<>(saveProyecto,HttpStatus.CREATED);
    }*/

    
    @PostMapping
    public Proyecto crearProyecto(@RequestBody ProyectoRequest proyecto){
        String usuarioId = proyecto.getUsuarioId();
        Optional<Usuario> usuario = usuarioServicio.getUsuarioById(usuarioId);
        Proyecto crearProyecto = proyecto.getProyecto();
        return proyectoServicio.crearProyecto(crearProyecto, usuario);
    }

    @GetMapping
    public ResponseEntity <List<Proyecto>> getAllProyectos(){
        List<Proyecto> proyecto= proyectoServicio.getAllProyectos();
        return new ResponseEntity<>(proyecto,HttpStatus.OK);
    }

    @GetMapping("/usuario")
    public List<Proyecto> obtenerProyectosDeUsuario(@RequestParam String documento) {
        // Llamar al servicio para obtener los proyectos del usuario con el documento proporcionado
        return proyectoServicio.getAllProyectosWithUsuario(documento);
    }

    @DeleteMapping("/{id_proyecto}")
    public ResponseEntity<Void>deleteProyectoById(@PathVariable String id_proyecto){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<Usuario>> getProyectoById(@PathVariable String usuario) {
        List<Proyecto> usr = proyectoServicio.getUsuarioById(usuario);
        if (usr.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 si no hay proyectos
        }
        return new ResponseEntity<>(HttpStatus.OK); 
        /*return usr.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    } */


    @PutMapping("/{id_proyecto}")
    public ResponseEntity<Proyecto> updateProyecto(@PathVariable int id_proyecto, @RequestBody Proyecto proyecto){
        Proyecto partialUpdateProyecto = new Proyecto();
        if (proyecto.getNombre() != null) {
            partialUpdateProyecto.setNombre(proyecto.getNombre());
        }
        if (proyecto.getDescripcion() != null) {
            partialUpdateProyecto.setDescripcion(proyecto.getDescripcion());
        }
        if (proyecto.getEstado() != null) {
            partialUpdateProyecto.setEstado(proyecto.getEstado());
        }
        if (proyecto.getCategoria() != null) {
            partialUpdateProyecto.setCategoria(proyecto.getCategoria());
        }
        if (proyecto.getFecha_inicio() != null) {
            partialUpdateProyecto.setFecha_inicio(proyecto.getFecha_inicio());
        }
        if (proyecto.getUbicacion() != null) {
            partialUpdateProyecto.setUbicacion(proyecto.getUbicacion());
        }
        Proyecto updatedProyecto = proyectoServicio.updateProyectoById(id_proyecto, partialUpdateProyecto);
        return new ResponseEntity<>(updatedProyecto,HttpStatus.OK);
    }
}
