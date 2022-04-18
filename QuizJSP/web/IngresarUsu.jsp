
<%@page import="Logico.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  String Cualquiercosa="Crear";
    Usuario objUsuario= null;
    objUsuario=(Usuario)request.getAttribute("Men");
    String Men=(String)request.getAttribute("Mens");
    if(Men==null){
        Men="false";
    }else{
        Cualquiercosa="Mostrar";
    }
    if(objUsuario==null){
          objUsuario=new Usuario(0,0,"","","","","");
          Cualquiercosa="Crear";
      }else{
        Cualquiercosa="Actulizar";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <link rel="stylesheet" href="CSS/StyleCSS.css"/>
    </head>
        <header>
            <h1><center>Usuario</center></h1>
        </header>
        <form action="Usu"  method="post">
        <center><table class="tabla">
            <tbody>
                 <tr>
                    <td><center>Carnet:</center></td>
            <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Carnet" value="<%=objUsuario.getCarnet()%>" /></center></td>
                                <%}else{
        
    %>
                    <td><center><input type="text" name="Carnet" value="<%=objUsuario.getCarnet()%>" readonly/></center></td>
                        <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Nombre:</center></td>
                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Nombre" value="<%=objUsuario.getNombre()%>" /></center></td>
                                <%}else{
        
    %>
                    <td><center><input type="text" name="Nombre" value="<%=objUsuario.getNombre()%>" readonly/></center></td>
                        <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Apellido</center></td>
                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Apellido" value="<%=objUsuario.getApellido()%>" /></center></td>
                                                    <%}else{
        
    %>
                    <td><center><input type="text" name="Apellido" value="<%=objUsuario.getApellido()%>" /></center></td>
                                            <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Correo Electronico:</center></td>
                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Correo_Electronico" value="<%=objUsuario.getCorreo_Electronico()%>" /></center></td>
                                                                        <%}else{
        
    %>
                    <td><center><input type="text" name="Correo_Electronico" value="<%=objUsuario.getCorreo_Electronico()%>" readonly/></center></td>
                                                                <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Direccion:</center></td>
                                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Direccion" value="<%=objUsuario.getDireccion()%>" /></center></td>
        <%}else{
        
    %>
                    <td><center><input type="text" name="Direccion" value="<%=objUsuario.getDireccion()%>" readonly/></center></td>
                                                                                    <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Telefono:</center></td>
                                                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="number" name="Telefono" value="<%=objUsuario.getTelefono()%>" /></center></td>
                            <%}else{
        
    %>
                    <td><center><input type="number" name="Telefono" value="<%=objUsuario.getTelefono()%>" readonly/></center></td>
                    <%}
    
    %>
                </tr>
                <tr>
                    <td><center>Estado:</center></td>
                                                                                                     <%
    if(Men.equals("false")){
    %>
                    <td><center><input type="text" name="Estado" value="<%=objUsuario.getEstado()%>" /></center></td>
                                                <%}else{
        
    %>
                    <td><center><input type="text" name="Estado" value="<%=objUsuario.getEstado()%>" readonly/></center></td>
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
                    out.println("<center><input type=\"button\" value=\"volver\" name=\"btnVolver\"class='buton' onclick=location.href='Gestionar_Usuarios.jsp'></center>");
        }%>
     </form>
    </body>
</html>
