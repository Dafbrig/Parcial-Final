<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca</title>
        <link rel="stylesheet" href="CSS/StyleCSS.css" type="text/css"/>
    </head>
    <body>
        <header>
            <h1><center>Bienvenido</center></h1>
        </header>
     <form action="Direccion"  method="post">
        <center><table class="tabla">
            <thead>
                <tr>
                    <th><center>Biblioteca</center></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><center><input type="radio" name="opc" value="1" />Gestionar Categorias</center></td>
                </tr>
                <tr>
                    <td><center><input type="radio" name="opc" value="2" />Gestionar Libros</center></td>
                </tr>
                <tr>
                    <td><center><input type="radio" name="opc" value="3" />Gestionar Usuarios</center></td>
                </tr>
                <tr>
                    <td><center><input type="radio" name="opc" value="4" />Gestionar Prestamos De libros</center></td>
                </tr>
                <tr>
                    <td><center><input type="radio" name="opc" value="5" />Gestionar Devoluciones</center></td>
                </tr>
                <tr>
                    <td><center><input type="radio" name="opc" value="6" />Mostrar Informes</center></td>
                </tr>
            </tbody>
        </center></table>
            <center><input type="submit" value="Enviar" class="buton" /></center>
      </form>   
    </body>
</html>
