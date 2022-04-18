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
public class Libro {
    
    int Codigo_Categoria,Numero_Ejemplares;
    String Titulo, Autor, Fecha_Ingreso, Estado,Codigo;
    
    Data.Conectar C=new Data.Conectar();
    
    public Conectar getC() {
        return C;
    }
    
    public Libro(){
        
    }

    public Libro(String Codigo, int Codigo_Categoria, int Numero_Ejemplares, String Titulo, String Autor, String Fecha_Ingreso, String Estado) {
        this.Codigo = Codigo;
        this.Codigo_Categoria = Codigo_Categoria;
        this.Numero_Ejemplares = Numero_Ejemplares;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Fecha_Ingreso = Fecha_Ingreso;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public int getCodigo_Categoria() {
        return Codigo_Categoria;
    }

    public void setCodigo_Categoria(int Codigo_Categoria) {
        this.Codigo_Categoria = Codigo_Categoria;
    }

    public int getNumero_Ejemplares() {
        return Numero_Ejemplares;
    }

    public void setNumero_Ejemplares(int Numero_Ejemplares) {
        this.Numero_Ejemplares = Numero_Ejemplares;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(String Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
