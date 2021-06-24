<%-- 
    Document   : buscarUsuario
    Created on : Jun 23, 2021, 4:57:06 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </head>
    <body>
        <jsp:useBean id="usuarioBean" scope="session" class="com.test.bean.UsuarioBean"/>
        <%! String salidaTabla = "";%>
        <%
            if (request.getParameter("search") != null) {
                String codUs = request.getParameter("codUsuario");
                //llamando al metodo busqueda de productos de una determinada categoria
                salidaTabla = usuarioBean.listarDatosUsuario(codUs);
            }
        %>
        <h1>Buscar datos de usuario determinado</h1>

        <div class="container">
            <form class="form-inline" method="POST">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Seleccione un usuario :</label>
                <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref"name="codUsuario">
                    <option selected>Choose...</option>
                    <%=usuarioBean.listarUsuarioSelect()%>

                </select>
                <button type="submit" class="btn btn-primary my-1" name="search">Mostrar</button>
            </form>
        </div>
        <br><br>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">codigo</th>
                        <th scope="col">Rol</th>
                        <th scope="col">nombre</th>
                        <th scope="col">apellidos</th>
                        <th scope="col">ci</th>
                        <th scope="col">password</th>
                    </tr>
                </thead>
                <tbody>

                    <%= salidaTabla%>
                </tbody>
            </table>
        </div>




    </body>
</html>
