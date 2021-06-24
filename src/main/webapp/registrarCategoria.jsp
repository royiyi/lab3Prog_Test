<%-- 
    Document   : registrarCategoria
    Created on : Jun 10, 2021, 4:13:51 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR CATEGORIA</title>
    </head>
    <body>
        <jsp:useBean id="categoria" scope="session" class="com.test.bean.CategoriaBean"/>
        <%
            if (request.getParameter("guardar") != null) {
                String mensaje = categoria.registrarCategoria(request);
                out.print(mensaje);
            }

            /*if (request.getParameter("guardar") != null) {
                String nam=request.getParameter("guardar");
                out.print(nam+"botonPRESIONADO "+request.getParameter("desCat"));
            }*/
        %>

        <h1>Categoria</h1>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr>

                        <th colspan="2">REGISTRAR CATEGORIA</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>NOMBRE:</td>
                        <td><input type="text" name="nomCat" value="" /></td>
                    </tr>
                    <tr>
                        <td>DESCRIPCION</td>
                        <td><input type="text" name="desCat" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="REGISTRAR" name="guardar" />
                        </td>

                    </tr>
                </tbody>
            </table>

        </form>
        <a href="index.jsp">INICIO</a>

    </body>
</html>
