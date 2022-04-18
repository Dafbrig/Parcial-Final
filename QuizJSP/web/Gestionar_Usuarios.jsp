<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Usuarios</title>
    <link rel="stylesheet" href="CSS/StyleCSS.css"/>
    </head>
    <body>
        <header>
            <h1><center>Gestionar Usuarios</center></h1>
        </header>
        <form action="Usu" method="post">
        <center><table class="tabla">
            <tbody>
                 <tr>
                    <td><center>Carnet:</center></td>
                    <td><center><input type="number" name="txCarnet" value="" /></center></td>
                </tr>
                    <td><center>Opcion:</center></td>
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
