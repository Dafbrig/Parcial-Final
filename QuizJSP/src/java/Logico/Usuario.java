/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import Data.Conectar;

/**
 *
 * @author Thanden
 */
public class Usuario {
    
    int Carnet;
    long  Telefono;
    String Nombre, Apellido, Correo_Electronico, Direccion, Estado;
    
    Data.Conectar C=new Data.Conectar();
    
    public Conectar getC() {
        return C;
    }
    public Usuario(){
        
    }
    public Usuario(int Carnet, long Telefono, String Nombre, String Apellido, String Correo_Electronico, String Direccion, String Estado) {
        this.Carnet = Carnet;
        this.Telefono = Telefono;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo_Electronico = Correo_Electronico;
        this.Direccion = Direccion;
        this.Estado = Estado;
    }

    public long getCarnet() {
        return Carnet;
    }

    public void setCarnet(int Carnet) {
        this.Carnet = Carnet;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    public String ErrorConsulta(){
        return C.getError();
    }
    
}
