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
 * @author Usuario
 */
public class UsuarioBean {

    private VariablesConexion variable;
    private Connection connection;

    public UsuarioBean() throws SQLException {
        variable = new VariablesConexion();
        variable.inicioConexion();
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");
    }
    @PreDestroy
    public void cerrarConexion() {
        variable.cerrarConexion();
    }
     public String listarUsuarioSelect() {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        
        query.append(" select u.cod_usu,CONCAT_WS(' ',u.nombres,u.ap_pat,u.ap_mat) fullname  ");
        query.append(" from usuario u ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            
            while (resultado.next()) {
                salidaTabla.append("<option value='");
                salidaTabla.append(resultado.getInt(1));
                salidaTabla.append("'>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</option>");
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("Error de Conexion");
        }

        return salidaTabla.toString();
    }
     //****************
      public String listarDatosUsuario(String codUsu) {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();

        query.append(" select u.codigo,r.nombre_rol,u.nombres,CONCAT_WS(' ',u.ap_pat,u.ap_mat),u.cedula,u.password ");
        query.append(" from usuario u ");
        query.append(" inner join rol r on r.cod_rol=u.cod_rol ");
        query.append(" where u.cod_usu = ? ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            //pasando la consulta 
            pst.setInt(1,Integer.parseInt(codUsu));
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            while (resultado.next()) {
                salidaTabla.append("<tr><td>");
                    salidaTabla.append(resultado.getString(1));
                salidaTabla.append("</td><td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td><td>");
                    salidaTabla.append(resultado.getString(3));
                    salidaTabla.append("</td><td>");
                    salidaTabla.append(resultado.getString(4));
                    salidaTabla.append("</td><td>");
                    salidaTabla.append(resultado.getInt(5));
                salidaTabla.append("</td><td>");
                salidaTabla.append(resultado.getString(6));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");

            }

        } catch (SQLException e) {
            e.printStackTrace();
         
        }

        return salidaTabla.toString();
    }
     
    

}
