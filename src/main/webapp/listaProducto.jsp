<%-- 
    Document   : listaProducto
    Created on : Jun 11, 2021, 12:31:47 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Productos</title>
    </head>
    <body>
        <jsp:useBean id="productoBean" scope="session" class="com.test.bean.ProductoBean"/>
        
        <h1>Lista Productos</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>COSTO UNIT. COMPRA</th>
                    <th>COSTO UNIT VENTA</th>
                    <th>STOCK</th>
                    <th>PROVEEDOR</th>
                    <th>CATEGORIA</th>
                </tr>
            </thead>
            <tbody>
                <%=productoBean.listarProducto()%>
            </tbody>
        </table>
               <a href="index.jsp">MANU INICIO</a>
        
    </body>
</html>
