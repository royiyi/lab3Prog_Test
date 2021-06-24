<%-- 
    Document   : index
    Created on : Jun 10, 2021, 6:26:44 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MENU DE OPCIONES</h1>

        <%
            out.print("this is one messaje");
            System.out.println("this is one messagei n console");

        %>
        
        <br>
        <a href="registrarCategoria.jsp">Registrar Categoria</a>
        <br>
        <a href="listaCategoria.jsp">Listar Categoria</a>
        <br>
        <a href="listaProducto.jsp">Listar Producto</a>
        <br>
         <a href="buscarProductoCategoria.jsp">BUSCAR PRODUCTO por CATEOGRIA</a>
    </body>
</html>
