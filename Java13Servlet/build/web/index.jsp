<%-- 
    Document   : index
    Created on : 08-feb-2018, 8:34:59
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel ="stylesheet" href="css/styles.css">
        <link rel ="stylesheet" href="css/cabecera.css">
        <script src="js/myscript.js"></script>
        <title>My JSP Page</title>
    </head>
    <body>
        <h1>Hello Everybody!</h1>
        <p>This is my first page con JSP</p>
        <p><button onclick="alert('Hoooola!')">Menudo botón</button>
        <p><button id="b1" onclick="testJS()">test JS</button>
        <p>Aquí está el <a href="Servlet1">Servlet1<a>
        <p>Y después el <a href="Servlet2">Servlet2<a> para leer DB
        <p>Introduciendo parámetros de búsqueda en este formulario los datos se muestran en Servlet3
        <div id="formulario">
            <form action="/Java13Servlet/Servlet3" method="post">
                Usuario: <input type="text" name="user" value="root"><br>
                Contraseña: <input type="password" name="password" value="hazerta"><br>
                IP: <input type="text" name="ip" value="localhost"><br>
                Base de datos: <input type="text" name="dbname" value="nba"><br>
                Tabla: <input type="text" name="table" value="jugadores"><br>
                Campo: <input type="text" name="field" value="Nombre_equipo"><br>
                Valor: <input type="text" name="valor" value="Bulls"><br>
                <input type="submit" value="Submit"><br>
            </form>
        </div>

    </body>
</html>
