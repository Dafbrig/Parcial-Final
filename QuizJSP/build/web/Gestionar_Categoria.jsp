<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
<%@page import="Logico.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Categoria</title>
        <link rel="stylesheet" href="CSS/StyleCSS.css"/>
    </head>
    <body>
        <header>
            <h1><center>Gestionar Categoria</center></h1>
        </header>
        <form action="Cat"  method="post">
            <center><table class="tabla">
            <tbody>
                <tr>
                    <td><center>Codigo:</center></td>
                    <td><center><input type="number" name="txCodigo" value="" /></center></td>
                </tr>
                <tr>
                    <td>Opcion:</td>
                    <td><center><select name="opc" class="selec">
                        <option value="0"></option>
                        <option value="1">Ingresar</option>
                        <option value="2">Modificar</option>
                        <option value="3">Consultar</option>
                        <option value="4">Eliminar</option>
                    </select></center></td>
                </tr>
            </tbody>
        </center></table>
       <center><input type="submit" value="Enviar" name="btEnviar" class="buton"/></center>
      </form>
    </body>
</html>
