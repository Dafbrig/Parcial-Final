/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logico.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanden
 */
@WebServlet(name = "Cat", urlPatterns = {"/Cat"})
public class Cat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cat</title>");            
            out.println("</head>");
            out.println("<body>");
            String En=request.getParameter("btEnviar");
            if(En.equals("Enviar")){
            String clave=request.getParameter("opc");
  switch(clave){
      case "1":
            response.sendRedirect("IngresarCat.jsp");
          break;
      case "2":
            int numero=Integer.parseInt(request.getParameter("txCodigo"));
            if(numero==0){
                out.println("<h1>Digite numero diferente a 0</h1>");
            }else{
            Categoria objCategoria=new Categoria();
            objCategoria.setCodigo(numero);
            objCategoria.getC().abrirConexion();
            ResultSet Ca=objCategoria.getC().BuscarCategoria(objCategoria);
                try {
                    if(Ca.next()){
                        objCategoria.setNombre(Ca.getString(2));
                        request.setAttribute("Men",objCategoria);
                        request.getRequestDispatcher("IngresarCat.jsp").forward(request, response);
                    }
                        } catch (SQLException ex) {
                            out.println("<h1>Numero no encontrado</h1>");
                }
            }
          break;
      case "3":
            numero=Integer.parseInt(request.getParameter("txCodigo"));
            if(numero==0){
                out.println("<h1>Digite numero diferente a 0</h1>");
            }else{
            Categoria objCategoria=new Categoria();
            objCategoria.setCodigo(numero);
            objCategoria.getC().abrirConexion();
            ResultSet Ca=objCategoria.getC().BuscarCategoria(objCategoria);
                try {
                    if(Ca.next()){
                        objCategoria.setNombre(Ca.getString(2));
                        request.setAttribute("Men",objCategoria);
                        request.setAttribute("Mens","true");
                        request.getRequestDispatcher("IngresarCat.jsp").forward(request, response);
                    }
                        } catch (SQLException ex) {
                            out.println("<h1>Numero no encontrado</h1>");
                }
            }
          break;
       case "4":
           Categoria objCategoria =new Categoria();
           try{
               objCategoria.setCodigo(Integer.parseInt(request.getParameter("txCodigo")));
               objCategoria.getC().abrirConexion();
               if(objCategoria.getC().EliminarCategoria(objCategoria)!=-1){
                out.println("<h1>Eliminado</h1>");
            }else{
                out.println("<h1>No eliminado</h1>");
            }
           }catch(Exception e){
               
           }
          break;
       default:
           response.sendRedirect("Index.jsp");
                }
        }else if(En.equals("Crear")){
            Categoria objCategoria =new Categoria();
            try{
            objCategoria.setCodigo(Integer.parseInt(request.getParameter("Codigo")));
            objCategoria.setNombre(request.getParameter("Nombre"));
            objCategoria.getC().abrirConexion();
            if(objCategoria.getC().ingresarCategoria(objCategoria)!=-1){
                out.println("<h1>Registro Exitoso</h1>");
            }else{
                out.println("<h1>Fallo de Registro</h1>");
            }
            }catch(Exception e){
                out.println("<h1>Fallo de Registro</h1>");
            }
            objCategoria.getC().cerrarConexion();
        }else if(En.equals("Actualizar")){
            Categoria objCategoria =new Categoria();
            int numero=Integer.parseInt(request.getParameter("Codigo"));
            String Nom=request.getParameter("Nombre");
            if(numero==0||Nom.isEmpty()){
                out.println("<h1>Algunos de los campos esta mal digitado</h1>");
            }else{
                objCategoria.setCodigo(numero);
                objCategoria.setNombre(Nom);
                objCategoria.getC().abrirConexion();
                if(objCategoria.getC().ActualizarCategoria(objCategoria)!=-1){
                    out.println("<h1>Registro Exitoso</h1>");
                }else{
                 out.println("<h1>No actualizar</h1>");   
                }                
                objCategoria.getC().cerrarConexion();
            }
            
        }
            out.println("<input type=\"button\" value=\"volver\" name=\"btnVolver\" onclick=location.href='Gestionar_Categoria.jsp'>");
            out.println("</body>");
            out.println("</html>");
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
