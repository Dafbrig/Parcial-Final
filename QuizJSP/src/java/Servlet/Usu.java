/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logico.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Thanden
 */
@WebServlet(name = "Usu", urlPatterns = {"/Usu"})
public class Usu extends HttpServlet {

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
            out.println("<title>Servlet Usu</title>");
            out.println("</head>");
            out.println("<body>");
            String En=request.getParameter("btEnviar");
            if(En.equals("Enviar")){
            String clave=request.getParameter("opc");
            switch(clave){
                 case "1":
            response.sendRedirect("IngresarUsu.jsp");
          break;
      case "2":
            int numero=Integer.parseInt(request.getParameter("txCarnet"));
            if(numero==0){
                out.println("<h1>Digite numero diferente a 0</h1>");
            }else{
            Usuario objUsuario=new Usuario();
            objUsuario.setCarnet(numero);
            objUsuario.getC().abrirConexion();
            ResultSet Ca=objUsuario.getC().BuscarUsuario(objUsuario);
                try {
                    if(Ca.next()){
                        objUsuario.setNombre(Ca.getString(2));
                        objUsuario.setApellido(Ca.getString(3));
                        objUsuario.setCorreo_Electronico(Ca.getString(4));
                        objUsuario.setDireccion(Ca.getString(5));
                        objUsuario.setTelefono(Ca.getLong(6));
                        objUsuario.setEstado(Ca.getString(7));
                        request.setAttribute("Men",objUsuario);
                        request.getRequestDispatcher("IngresarUsu.jsp").forward(request, response);
                    }
                        } catch (SQLException ex) {
                            out.println("<h1>Usuario no encontrado</h1>");
                }
            }
          break;
      case "3":
            numero=Integer.parseInt(request.getParameter("txCarnet"));
            if(numero==0){
                out.println("<h1>Digite Carnet diferente a 0</h1>");
            }else{
            Usuario objUsuario=new Usuario();
            objUsuario.setCarnet(numero);
            objUsuario.getC().abrirConexion();
            ResultSet Ca=objUsuario.getC().BuscarUsuario(objUsuario);
                try {
                    if(Ca.next()){
                        objUsuario.setNombre(Ca.getString(2));
                        objUsuario.setApellido(Ca.getString(3));
                        objUsuario.setCorreo_Electronico(Ca.getString(4));
                        objUsuario.setDireccion(Ca.getString(5));
                        objUsuario.setTelefono(Ca.getLong(6));
                        objUsuario.setEstado(Ca.getString(7));
                        request.setAttribute("Men",objUsuario);
                        request.setAttribute("Mens","true");
                        request.getRequestDispatcher("IngresarUsu.jsp").forward(request, response);
                    }
                        } catch (SQLException ex) {
                            out.println("<h1>Numero no encontrado</h1>");
                }
            }
          break;
       case "4":
           Usuario objUsuario =new Usuario();
           try{
               objUsuario.setCarnet(Integer.parseInt(request.getParameter("txCarnet")));
               objUsuario.getC().abrirConexion();
               if(objUsuario.getC().EliminarUsuario(objUsuario)!=-1){
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
            Usuario objUsuario =new Usuario();
            try{
            objUsuario.setCarnet(Integer.parseInt(request.getParameter("Carnet")));
            objUsuario.setNombre(request.getParameter("Nombre"));
            objUsuario.setApellido(request.getParameter("Apellido"));
            objUsuario.setCorreo_Electronico(request.getParameter("Correo_Electronico"));
            objUsuario.setDireccion(request.getParameter("Direccion"));
            objUsuario.setTelefono(Long.parseLong(request.getParameter("Telefono")));
            objUsuario.setEstado(request.getParameter("Estado"));
            objUsuario.getC().abrirConexion();
            if(objUsuario.getC().ingresarUsuario(objUsuario)!=-1){
                out.println("<h1>Registro Exitoso</h1>");
            }else{
                out.println("<h1>Fallo de Registro</h1>");
            }
            }catch(Exception e){
                out.println("<h1>Fallo de Registro</h1>");
            }
            objUsuario.getC().cerrarConexion();
        }else if(En.equals("Actualizar")){
            Usuario objUsuario =new Usuario();
            int numero=Integer.parseInt(request.getParameter("Codigo"));
            String Nom=request.getParameter("Nombre");
            String Ape=request.getParameter("Apellido");
            String Corr=request.getParameter("Correo_Electronico");
            String Dir=request.getParameter("Direccion");
            long Tel=Long.parseLong(request.getParameter("Telefono"));
            String Est=request.getParameter("Estado");
            if(numero==0||Nom.isEmpty()||Ape.isEmpty()||Corr.isEmpty()||Dir.isEmpty()||Tel==0||Est.isEmpty()){
                out.println("<h1>Algunos de los campos esta mal digitado</h1>");
            }else{
                objUsuario.setCarnet(numero);
                objUsuario.setNombre(Nom);
                objUsuario.setApellido(Ape);
                objUsuario.setCorreo_Electronico(Corr);
                objUsuario.setDireccion(Dir);
                objUsuario.setTelefono(Tel);
                objUsuario.setEstado(Est);
                objUsuario.getC().abrirConexion();
                if(objUsuario.getC().ActualizarUsuario(objUsuario)!=-1){
                    out.println("<h1>Registro Exitoso</h1>");
                }else{
                 out.println("<h1>No actualizar</h1>");   
                }                
                objUsuario.getC().cerrarConexion();
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
