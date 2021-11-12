package Objetos;

import java.util.Objects;

public class Usuarios {

    private int id;
    private String usuario,usuario1;
    private String pass,pass2;

    public Usuarios(){

        usuario="Rodrigo";
        pass="123";
        usuario1="Cristian";
        pass2="123";
    }

    public Usuarios(int id, String usuario, String usuario1, String pass, String pass2) {
        this.id = id;
        this.usuario = usuario;
        this.usuario1 = usuario1;
        this.pass = pass;
        this.pass2 = pass2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id && Objects.equals(usuario, usuarios.usuario) && Objects.equals(usuario1, usuarios.usuario1) && Objects.equals(pass, usuarios.pass) && Objects.equals(pass2, usuarios.pass2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, usuario1, pass, pass2);
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", usuario1='" + usuario1 + '\'' +
                ", pass='" + pass + '\'' +
                ", pass2='" + pass2 + '\'' +
                '}';
    }
}
