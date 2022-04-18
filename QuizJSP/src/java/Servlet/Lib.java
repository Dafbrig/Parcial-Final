/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logico.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thanden
 */
@WebServlet(name = "Lib", urlPatterns = {"/Lib"})
public class Lib extends HttpServlet {

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
            out.println("<title>Servlet Lib</title>");            
            out.println("</head>");
            out.println("<body>");
             String En=request.getParameter("btEnviar");
            if(En.equals("Enviar")){
            String clave=request.getParameter("opc");
            switch(clave){
                 case "1":
            response.sendRedirect("IngresarLib.jsp");
          break;
      case "2":
            String numero=request.getParameter("txCodigo");
            if(numero==""){
                out.println("<h1>Digite un codigo</h1>");
            }else{
            Libro objLibro=new Libro();
            objLibro.setCodigo(numero);
            objLibro.getC().abrirConexion();
            ResultSet Ca=objLibro.getC().BuscarLibro(objLibro);
                try {
                    if(Ca.next()){
                        objLibro.setTitulo(Ca.getString(2));
                        objLibro.setAutor(Ca.getString(3));
                        objLibro.setFecha_Ingreso(Ca.getString(4));
                        objLibro.setNumero_Ejemplares(Ca.getInt(5));
                        objLibro.setCodigo_Categoria(Ca.getInt(6));
                        objLibro.setEstado(Ca.getString(7));
                        request.setAttribute("Men",objLibro);
                        request.getRequestDispatcher("IngresarLib.jsp").forward(request, response);
                    }
                        } catch (SQLException ex) {
                            out.println("<h1>Libro no encontrado</h1>");
                }
            }
          break;
      case "3":
            numero=request.getParameter("txCodigo");
            if(numero==""){
                out.println("<h1>Digite un Codigo</h1>");
            }else{
            Libro objLibro=new Libro();
            objLibro.setCodigo(numero);
            objLibro.getC().abrirConexion();
            ResultSet Ca=objLibro.getC().BuscarLibro(objLibro);
                try {
                    if(Ca.next()){
                        objLibro.setTitulo(Ca.getString(2));
                        objLibro.setAutor(Ca.getString(3));
                        objLibro.setFecha_Ingreso(Ca.getString(4));
                        objLibro.setNumero_Ejemplares(Ca.getInt(5));
                        objLibro.setCodigo_Categoria(Ca.getInt(6));
                        objLibro.setEstado(Ca.getString(7));
                        request.setAttribute("Men",objLibro);
                        request.setAttribute("Mens","true");
                        request.getRequestDispatcher("IngresarLib.jsp").forward(request, response);
                    }
                        } catch (SQLException ex) {
                            out.println("<h1>Libro no encontrado</h1>");
                }
            }
          break;
       case "4":
           Libro objLibro =new Libro();
           try{
               objLibro.setCodigo(request.getParameter("txCarnet"));
               objLibro.getC().abrirConexion();
               if(objLibro.getC().EliminarLibro(objLibro)!=-1){
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
            Libro objLibro =new Libro();
            try{
            objLibro.setCodigo(request.getParameter("Codigo"));
            objLibro.setTitulo(request.getParameter("Titulo"));
            objLibro.setAutor(request.getParameter("Autor"));
            objLibro.setFecha_Ingreso(request.getParameter("Fecha_Ingreso"));
            objLibro.setNumero_Ejemplares(Integer.parseInt(request.getParameter("Direccion")));
            objLibro.setCodigo_Categoria(Integer.parseInt(request.getParameter("Telefono")));
            objLibro.setEstado(request.getParameter("Estado"));
            objLibro.getC().abrirConexion();
            if(objLibro.getC().ingresarLibro(objLibro)!=-1){
                out.println("<h1>Registro Exitoso</h1>");
            }else{
                out.println("<h1>Fallo de Registro</h1>");
            }
            }catch(Exception e){
                out.println("<h1>Fallo de Registro</h1>");
            }
            objLibro.getC().cerrarConexion();
        }else if(En.equals("Actualizar")){
            Libro objLibro =new Libro();
            String Cod=request.getParameter("Codigo");
            String Tit=request.getParameter("Titulo");
            String Aut=request.getParameter("Autor");
            String Fech=request.getParameter("Fecha_Ingreso");
            int Num=Integer.parseInt(request.getParameter("Numero_Ejemplares"));
            int Codi=Integer.parseInt(request.getParameter("Codigo_Categoria"));
            String Est=request.getParameter("Estado");
            if(Cod.isEmpty()||Tit.isEmpty()||Aut.isEmpty()||Fech.isEmpty()||Num==0||Codi==0||Est.isEmpty()){
                out.println("<h1>Algunos de los campos esta mal digitado</h1>");
            }else{
                objLibro.setCodigo(Cod);
                objLibro.setTitulo(Tit);
                objLibro.setAutor(Aut);
                objLibro.setFecha_Ingreso(Fech);
                objLibro.setNumero_Ejemplares(Num);
                objLibro.setCodigo_Categoria(Codi);
                objLibro.setEstado(Est);
                objLibro.getC().abrirConexion();
                if(objLibro.getC().ActualizarLibro(objLibro)!=-1){
                    out.println("<h1>Registro Exitoso</h1>");
                }else{
                 out.println("<h1>No actualizar</h1>");   
                }                
                objLibro.getC().cerrarConexion();
            }
            }
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
