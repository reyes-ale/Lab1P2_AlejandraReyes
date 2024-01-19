/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_alejandrareyes;

/**
 *
 * @author aleja
 */
public class Usuario {
    String nombre;
    String apellido;
    String correo; 
    int anio;
    int dia;
    int mes; 

    public Usuario(String nombre, String apellido, String correo, int anio, int dia, int mes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.anio = anio;
        this.dia = dia;
        this.mes = mes;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    
}
