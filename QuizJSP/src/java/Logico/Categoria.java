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
public class Categoria {
    int Codigo;
    String Nombre;
    
    Data.Conectar C=new Data.Conectar();
    
    public Conectar getC() {
        return C;
    }
    public Categoria(){
        
    }

    public Categoria(int Codigo, String Nombre) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String ErrorConsulta(){
        return C.getError();
    }
    
}
