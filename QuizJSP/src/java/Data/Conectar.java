/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logico.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conectar {
     private Connection conexion;
    private String strConex,Error;

    public Conectar() {
        String nombreBD="Biblioteca";
        this.strConex="jdbc:sqlserver://DESKTOP-LCKAILD\\SQLEXPRESS:1433;databaseName=" + nombreBD + ";user=UsuarioSQL;password=321;";
        conexion=abrirConexion();
    }
    
    public Connection abrirConexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con= DriverManager.getConnection(strConex);
            return con;
        }catch(Exception ex){
            Error=ex.getMessage();
            return null;
        }
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(Exception ex){
            Error=ex.getMessage();
        }
    }
    public ResultSet Consultas(String inst){
        try{
            Statement s = conexion.createStatement();
            ResultSet resultado=s.executeQuery(inst);
            return resultado;
        }catch(Exception ex){
            Error=ex.getMessage();
            return null;
        }
    }
    public int Operaciones(String inst){
        try{
            Statement s = conexion.createStatement();
            return s.executeUpdate(inst);
        }catch(Exception ex){
            Error=ex.getMessage();
            return -1;
       }
    }
    public String getError() {
        return Error;
    }
    public Connection getConexion() {
        return conexion;
    }
    public int ingresarUsuario(Usuario objUsuario){
           return Operaciones("INSERT INTO Usuario VALUES("+objUsuario.getCarnet()+",'"+objUsuario.getNombre()+"',"
                    + "'"+objUsuario.getApellido()+"',"+objUsuario.getTelefono()+",'"+objUsuario.getCorreo_Electronico()+"',"+objUsuario.getDireccion()+","+objUsuario.getTelefono()+","+objUsuario.getEstado()+")");
    }
    public int  ingresarLibro(Libro objLibro){
           return Operaciones("INSERT INTO Libro VALUES('"+objLibro.getCodigo()+"','"+objLibro.getTitulo()+"',"
                    + "'"+objLibro.getAutor()+",'"+objLibro.getFecha_Ingreso()+"',"+objLibro.getNumero_Ejemplares()+","+objLibro.getCodigo_Categoria()+","+objLibro.getEstado()+")");
    }
    public int  ingresarCategoria(Categoria objCategoria){
           return Operaciones("INSERT INTO Categoria VALUES("+objCategoria.getCodigo()+",'"+objCategoria.getNombre()+"')");
    }
    public ResultSet ConsultarCategoria(Categoria objCategoria){
           return Consultas("Select Codigo, Nombre from Categoria where Codigo="+objCategoria.getCodigo());
    }
    public ResultSet ConsultarUsuario(Usuario objUsuario){
           return Consultas("Select Carnet, Nombre, Apellido,Correo_Electronico,Direccion,Telefono,Estado from Usuario where Carnet="+objUsuario.getCarnet());
    }
    public ResultSet ConsultarLibro(Libro objLibro){
           return Consultas("Select L.Codigo,L.Titulo,L.Autor,L.Fecha_Ingreso,L.Numero_Ejemplares,L.Estado,L.Estado,C.Nombre from Libro L inner join Categoria C on L.Codigo_Categoria=C.Codigo where L.Codigo=="+"'"+objLibro.getCodigo()+"'");
    }
    public int  EliminarLibro(Libro objLibro){
           return Operaciones("Delete from Libro where Codigo=="+"'"+objLibro.getCodigo()+"'");
    }
    public int  EliminarUsuario(Usuario objUsuario){
           return Operaciones("Delete from Usuario where Carnet="+objUsuario.getCarnet());
    }
    public int  EliminarCategoria(Categoria objCategoria){
           return Operaciones("Delete from Categoria where Codigo="+objCategoria.getCodigo());
    }
    public ResultSet SelectLibros(){
           return Consultas("Select * from Libro");
    }
    public ResultSet datosUsuario(int Carnet, String Nombre, String Apellido){
        try {
            ResultSet resultado=Consultas("SELECT * FROM Usuario WHERE Carnet="+Carnet+" AND Nombre='"+Nombre+"' AND Apellido=''"+Apellido+"");
            return resultado;
        } catch (Exception ex) {
            return null;
        }
    }
    public ResultSet BuscarCategoria(Categoria objCategoria){
           return Consultas("Select * from Categoria where Codigo="+objCategoria.getCodigo());
    }
    public ResultSet BuscarUsuario(Usuario objUsuario){
           return Consultas("Select * from Usuario where Carnet="+objUsuario.getCarnet());
    }
    public ResultSet BuscarLibro(Libro objLibro){
           return Consultas("Select * from Libro where Codigo="+objLibro.getCodigo());
    }
    public int ActualizarCategoria(Categoria objCategoria){
           return Operaciones("Update Categoria set Nombre='"+objCategoria.getNombre()+"' where Codigo="+objCategoria.getCodigo());
    }
  
    public int ActualizarUsuario(Usuario objUsuario){
           return Operaciones("Update Usuario set Nombre='"+objUsuario.getNombre()+"',Apellido='"+objUsuario.getApellido()
                   +"',"+"Correo_Electronico='"+objUsuario.getCorreo_Electronico()+"',Direccion='"+objUsuario.getDireccion()
                   +"',Telefono="+objUsuario.getTelefono()+",Estado='"+objUsuario.getEstado()+"' where Carnet="+objUsuario.getCarnet());
    }
    public int ActualizarLibro(Libro objLibro){
           return Operaciones("Update Usuario set Titulo='"+objLibro.getTitulo()+"',Autor='"+objLibro.getAutor()+"',"
                   +"Fecha_Ingreso='"+objLibro.getFecha_Ingreso()+"',Numero_Ejemplares="+objLibro.getNumero_Ejemplares()
                   +",Codigo_Categoria="+objLibro.getCodigo_Categoria()+",Estado='"+objLibro.getEstado()+"' where Codigo='"+objLibro.getCodigo()+"'");
    }
}    