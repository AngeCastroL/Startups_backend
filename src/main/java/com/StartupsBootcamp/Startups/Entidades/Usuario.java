package com.StartupsBootcamp.Startups.Entidades;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {

    @Id
    private String documento;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo_documento;

    @Column(nullable = false, length = 100)
    protected String usuario;

    @Column(nullable = false, length = 100)
    protected String contrasenia;

    @Column(nullable = false, length = 100)
    protected String correo;

    @Column(unique = true,nullable = false, length = 100)
    private String telefono;

    @Column(columnDefinition = "DATE")
    private Date fecha_nacimiento;

    @OneToMany(targetEntity = Proyecto.class,fetch = FetchType.LAZY,mappedBy = "usuario")
    private  List<Proyecto> proyecto;

    public Usuario() {
    }

    public Usuario(String documento, String nombre, String apellido, TipoDocumento tipo_documento, String usuario,
            String contrasenia, String correo, String telefono, Date fecha_nacimiento) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Usuario [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_documento="
                + tipo_documento + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", correo=" + correo
                + ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + "]";
    }

    

    
}
