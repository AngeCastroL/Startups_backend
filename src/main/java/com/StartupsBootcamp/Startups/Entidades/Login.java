package com.StartupsBootcamp.Startups.Entidades;

public class Login {
    private String documento; // Campo para el nombre de usuario
    private String contrasenia; // Campo para la contraseña



    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
