package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Direccion", urlPatterns = {"/Direccion"})
public class Direccion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String clave=request.getParameter("opc");
             
  switch(clave){
      case "1":
            response.sendRedirect("Gestionar_Categoria.jsp");
          break;
      case "2":
            response.sendRedirect("Gestionar_Libros.jsp");
          break;
      case "3":
            response.sendRedirect("Gestionar_Usuarios.jsp");
          break;
       case "4":
             response.sendRedirect("Gestionar_Prestamos_De_libros.jsp");
          break;
       case "5":
             response.sendRedirect("Gestionar_Devoluciones.jsp");
          break;
       case "6":
             response.sendRedirect("Mostrar_Informes.jsp");
          break;
       default:
           response.sendRedirect("Index.jsp");
                }  
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
