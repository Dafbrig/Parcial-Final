<%@page import="java.util.ArrayList"%>
<%@page import="Data.Conectar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%      
        ResultSet Consultas;
        Conectar objCon=new Conectar();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Informes</title>
    </head>
    <body>
        <section>
        <%
        objCon.abrirConexion();
        Consultas=objCon.SelectLibros();
          out.println("<section>"); 
        out.println("<table cellspacing=0>");
            out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Codigo</th>");
                   out.println("<th>Titulo</th>");
                    out.println("<th>Autor</th>");
                    out.println("<th>Categoria</th>");
                    out.println("<th>Fecha de ingreso</th>");
                    out.println("<th>Estado</th>");
                    out.println("<th>Ejemplares</th>");
                out.println("</tr>");
                       out.println("</thead>");
                              out.println("<tbody>");
                         while(Consultas.next()){
                            out.println("<tr>");
                            out.println("<td>"+Consultas.getString(1)+"</td>");
                            out.println("<td>"+Consultas.getString(2)+"</td>");
                            out.println("<td>"+Consultas.getString(3)+"</td>");   
                            out.println("<td>"+Consultas.getInt(6)+"</td>");
                            out.println("<td>"+Consultas.getDate(4)+"</td>");
                            out.println("<td>"+Consultas.getString(7)+"</td>");
                            out.println("<td>"+Consultas.getInt(5)+"</td>");
                            out.println("</tr>");
                            }
                         out.println("</tbody>");
                         out.println("</table>");
                         out.println("</section>");
                         Consultas.close();
                         out.println("<br><br>");
        %> 
      </section>
    </body>
</html>
