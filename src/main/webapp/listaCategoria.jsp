<%-- 
    Document   : listaCategoria
    Created on : Jun 11, 2021, 11:26:23 AM
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
        <h1>LISTA CATEGORIA</h1>
        <jsp:useBean id="categoriaBen" scope="session" class="com.test.bean.CategoriaBean"/>
        <table border="1" bgcolor="#aabbcc">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                </tr>
            </thead>
            <tbody>
                <%=categoriaBen.listarCategoria()%>
            </tbody>
        </table>
            <a href="index.jsp">MANU INICIO</a>

    </body>
</html>
