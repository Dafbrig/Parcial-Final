<%-- 
    Document   : IngresarLib
    Created on : 11/06/2020, 09:33:59 PM
    Author     : Thanden
--%>
<%@page import="Logico.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  String Cualquiercosa="Crear";
    Libro objLibro= null;
    objLibro=(Libro)request.getAttribute("Men");
    String Men=(String)request.getAttribute("Mens");
    if(Men==null){
        Men="false";
    }else{
        Cualquiercosa="Mostrar";
    }
    if(objLibro==null){
          objLibro=new Libro("",0,0,"","","","");
          Cualquiercosa="Crear";
      }else{
        Cualquiercosa="Actulizar";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libro</title>
        <link rel="stylesheet" href="CSS/StyleCSS.css"/>
    </head>
        <header>
            <h1><center>Libro</center></h1>
        </header>
        <form action="Lib"  method="post">
        <center><table class="tabla">
            <tbody>
                 <tr>
                    <td><center>Codigo:</center></td>
            <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Codigo" value="<%=objLibro.getCodigo()%>" /></center></td>
                                <%}else{
        
    %>
                    <td><center><input type="text" name="Codigo" value="<%=objLibro.getCodigo()%>" readonly/></center></td>
                        <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Titulo:</center></td>
                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Titulo" value="<%=objLibro.getTitulo()%>" /></center></td>
                                <%}else{
        
    %>
                    <td><center><input type="text" name="Titulo" value="<%=objLibro.getTitulo()%>" readonly/></center></td>
                        <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Autor:</center></td>
                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Autor" value="<%=objLibro.getAutor()%>" /></center></td>
                                                    <%}else{
        
    %>
                    <td><center><input type="text" name="Autor" value="<%=objLibro.getAutor()%>" /></center></td>
                                            <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Fecha Ingreso:</center></td>
                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Fecha_Ingreso" value="<%=objLibro.getFecha_Ingreso()%>" /></center></td>
                                                                        <%}else{
        
    %>
                    <td><center><input type="text" name="Fecha_Ingreso" value="<%=objLibro.getFecha_Ingreso()%>" readonly/></center></td>
                                                                <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Numero Ejemplares:</center></td>
                                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="number" name="Numero_Ejemplares" value="<%=objLibro.getNumero_Ejemplares()%>" /></center></td>
        <%}else{
        
    %>
                    <td><center><input type="number" name="Numero_Ejemplares" value="<%=objLibro.getNumero_Ejemplares()%>" readonly/></center></td>
                                                                                    <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Codigo Categoria:</center></td>
                                                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="number" name="Codigo_Categoria" value="<%=objLibro.getCodigo_Categoria()%>" /></center></td>
                            <%}else{
        
    %>
                    <td><center><input type="number" name="Codigo_Categoria" value="<%=objLibro.getCodigo_Categoria()%>" readonly/></center></td>
                    <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Estado:</center></td>
                                                                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Estado" value="<%=objLibro.getEstado()%>" /></center></td>
                                                <%}else{
        
    %>
                    <td><center><input type="text" name="Estado" value="<%=objLibro.getEstado()%>" readonly/></center></td>
                                        <%}
    
    %>
                </tr>
            </tbody>
            </center></table>
                    <% 
        if(Cualquiercosa.equals("Crear")){
            out.println("<center><input type='submit' value='Crear' name='btEnviar' class='buton'/></center>");
            }else if(Cualquiercosa.equals("Actulizar")){
            out.println("<center><input type='submit' value='Actualizar' name='btEnviar' class='buton'/></center>");
                }else if(Cualquiercosa.equals("Mostrar")){
                    out.println("<center><input type=\"button\" value=\"volver\" name=\"btnVolver\"class='buton' onclick=location.href='Gestionar_Libros.jsp'></center>");
        }%>
     </form>
    </body>
</html>
