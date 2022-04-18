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
public class Prestamo {
    
    int Codigo_Libro, Carnet_Usuario;
    String Fecha_Prestamo,Fecha_Devolucion_Estandar,Fecha_Devolucion_Usuario,Estado;
    double Dinero;       
            
    Data.Conectar C=new Data.Conectar();
    public Conectar getC() {
        return C;
    }
}
