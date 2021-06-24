/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;

/**
 *
 * @author Royer ACUÑA
 */
public class ProductoBean {

    private VariablesConexion variable;
    private Connection connection;

    public ProductoBean() throws SQLException {
        variable = new VariablesConexion();
        variable.inicioConexion();
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");

    }

    @PreDestroy//cuando ya no la estemos utilizando automaticamente se ejecutara y se serrara la conexion
    public void cerrarConexion() {
        variable.cerrarConexion();
    }

    //metodos
    public String listarProducto() {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();

        query.append(" SELECT P.RAZON_SOCIAL,C.NOM_CAT,A.NOM_PRO,A.DES_PRO,A.COSTO_UC,A.COSTO_UV,A.STOCK ");
        query.append(" FROM PRODUCTO A ");
        query.append(" INNER JOIN CATEGORIA C ON  A.COD_CAT = C.COD_CAT ");
        query.append(" INNER JOIN PROVEEDOR P ON  A.COD_PROV = P.COD_PROV ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            while (resultado.next()) {
                salidaTabla.append("<tr>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(1));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(3));
                    salidaTabla.append("</td>");
                    //cuando tiene 2 decimales puede ser float o double
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(4));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getDouble(5));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(6));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getInt(7));
                    salidaTabla.append("</td>");
                salidaTabla.append("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de Conexion");
        }

        return salidaTabla.toString();
    }
    //Busca todos los productos de una determinada categoria
    public String listarProductoCategoria(String codCat) {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();

        query.append(" SELECT A.NOM_PRO,A.DES_PRO,A.COSTO_UC,A.COSTO_UV,A.STOCK,C.RAZON_SOCIAL ");
        query.append(" FROM PRODUCTO A ");
        query.append(" INNER JOIN PROVEEDOR C ON  A.COD_PROV = C.COD_PROV ");
        query.append(" where A.COD_CAT = ? ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            //pasando la consulta 
            pst.setInt(1,Integer.parseInt(codCat));
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            while (resultado.next()) {
                salidaTabla.append("<tr>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(1));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(3));
                    salidaTabla.append("</td>");
                    //cuando tiene 2 decimales puede ser float o double
                
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getDouble(4));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(5));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(6));
                    salidaTabla.append("</td>");
                salidaTabla.append("</tr>");

            }

        } catch (SQLException e) {
            e.printStackTrace();
         
        }

        return salidaTabla.toString();
    }
    //***************
    public String listarProductoStock(String numStock) {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();

        query.append(" SELECT A.NOM_PRO,A.DES_PRO,A.COSTO_UC,A.COSTO_UV,A.STOCK,C.RAZON_SOCIAL,T.NOM_CAT ");
        query.append(" FROM PRODUCTO A ");
        query.append(" INNER JOIN CATEGORIA T ON  A.COD_CAT = T.COD_CAT ");
        query.append(" INNER JOIN PROVEEDOR C ON  A.COD_PROV = C.COD_PROV ");
        query.append(" where A.STOCK <= ? ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            //pasando la consulta 
            pst.setInt(1,Integer.parseInt(numStock));
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            while (resultado.next()) {
                salidaTabla.append("<tr>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(1));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(3));
                    salidaTabla.append("</td>");
                    //cuando tiene 2 decimales puede ser float o double
                
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getDouble(4));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(5));
                salidaTabla.append("</td>");
                    salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(6));
                    salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                    salidaTabla.append(resultado.getString(7));
                    salidaTabla.append("</td>");
                salidaTabla.append("</tr>");

            }

        } catch (SQLException e) {
            e.printStackTrace();
         
        }

        return salidaTabla.toString();
    }
    

}
