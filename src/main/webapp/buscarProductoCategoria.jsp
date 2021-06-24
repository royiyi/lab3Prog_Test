<%-- 
    Document   : buscarProductoCategoria
    Created on : Jun 11, 2021, 1:29:01 PM
    Author     : Usuario
--%>

<%@page import="com.test.bean.CategoriaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar</title>
    </head>
    <body>
        <h1>BUSCAR producto por CATEGORIA</h1>
        <jsp:useBean id="categoriaBeanaa" scope="session" class="com.test.bean.CategoriaBean"/>
        
        <jsp:useBean id="productoBean" scope="session" class="com.test.bean.ProductoBean"/>
        
        <%! String salidaTabla = "";%>  
        
        <%
            if (request.getParameter("buscar") != null) {
                String codCat = request.getParameter("codCategoria");
                //llamando al metodo busqueda de productos de una determinada categoria
                salidaTabla = productoBean.listarProductoCategoria(codCat);
            }
        %>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr >

                        <th colspan="3">Categoria</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>

                        <td colspan="2">
                            <select name="codCategoria">
                                <!-- /* el id debe coincidir con el objeto que llama los metodos
                                sino dara error
                                */-->
                                <%=categoriaBeanaa.listarCategoriaSelect()%>
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="BUSCAR" name="buscar" />
                        </td>
                    </tr>

                </tbody>
            </table>


            <table border="1">
                <thead>
                    <tr>
                        <th>PRODUCTO</th>
                        <th>DESCRIPCION</th>
                        <th>COSTO UNIT. COMPRA</th>
                        <th>COSTO UNIT. VENTA</th>
                        <th>STOCK</th>
                        <th>PROVEEDOR</th>
                    </tr>
                </thead>
                <tbody>
                    <%= salidaTabla%>
                </tbody>
            </table>

        </form>
        <a href="index.jsp">MANU INICIO</a>
    </body>
</html>
