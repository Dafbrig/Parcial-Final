<%@page import="Logico.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
    Categoria objCategoria= null;
    objCategoria=(Categoria)request.getAttribute("Men");
    String Men=(String)request.getAttribute("Mens");
    String Cualquiercosa="";
    if(Men==null){
        Men="false";
    }else{
        Cualquiercosa="Mostrar";
    }
    if(objCategoria==null){
          objCategoria=new Categoria(0,"");
          Cualquiercosa="Crear";
      }else{
        Cualquiercosa="Actulizar";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria</title>
        <link rel="stylesheet" href="CSS/StyleCSS.css"/>
    </head>
    <body>
         <header>
            <h1><center>Categoria</center></h1>
        </header>
        <form action="Cat" method="post">
        <center><table class="tabla">
            <tbody>
                <tr>
                    <td><center>Codigo:</center></td>
            <%
    if(Men.equals("false")){
    %>
            <td><center><input type="text" name="Codigo" value="<%=objCategoria.getCodigo()%>"/></center></td>
         
            <%}else{
        
    %>
     <td><center><input type="text" name="Codigo" value="<%=objCategoria.getCodigo()%>" readonly/></center></td>
    <%}
    
    %>
    </tr>
                <tr>
                    <td><center>Nombre:</center></td>
     <%
    if(Men.equals("false")){
    %>
            <td><center><input type="text" name="Nombre" value="<%=objCategoria.getNombre()%>"/></center></td>
            <%}else{
        
    %>
     <td><center><input type="text" name="Nombre" value="<%=objCategoria.getNombre()%>" readonly/></center></td>
    <%}
    
    %>
                </tr>
            </tbody>
        </table>
      </center>
        <% 
        if(Cualquiercosa.equals("Crear")){
            out.println("<center><input type='submit' value='Crear' name='btEnviar' class='buton'/></center>");
            }else if(Cualquiercosa.equals("Actulizar")){
            out.println("<center><input type='submit' value='Actualizar' name='btEnviar' class='buton'/></center>");
                }else if(Cualquiercosa.equals("Mostrar")){
                    out.println("<center><input type=\"button\" value=\"volver\" name=\"btnVolver\"class='buton' onclick=location.href='Gestionar_Categoria.jsp'></center>");
        }%>
     </form>
    </body>
</html>
