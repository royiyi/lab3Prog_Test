<%-- 
    Document   : listarStockMenor
    Created on : Jun 23, 2021, 7:11:05 PM
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
        <jsp:useBean id="productoBean" scope="session" class="com.test.bean.ProductoBean"/>
          
        <%! String salidaTabla = "";%>  
        
        <%
            
            if (request.getParameter("buscar") != null) {
                String codNum = request.getParameter("Nrango");
                //llamando al metodo busqueda de productos de una determinada categoria
                salidaTabla = productoBean.listarProductoStock(codNum);
            }
        %>
        
        <h1>Productos con Stock Menos a 10 Unidades</h1>
        <div class="container">
            <form class="form-inline" method="POST">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Digite el numero n (stock <= n) :</label>
               
                     <input type="number"min=1 max= 300 class="form-control" id="inputPassword2" placeholder="10" name="Nrango">
                <button type="submit" class="btn btn-primary my-1" name="buscar">Mostrar</button>
            </form>
        </div>
        <br><br>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">DESCRIPCION</th>
                        <th scope="col">COSTO UNIT. COMPRA</th>
                        <th scope="col">COSTO UNIT VENTA</th>
                        <th scope="col">STOCK</th>
                        <th scope="col">PROVEEDOR</th>
                        <th scope="col">CATEGORIA</th>
                    </tr>
                </thead>
                <tbody>

                    <%= salidaTabla%>
                </tbody>
            </table>
        </div>



    </body>
</html>
