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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.sql.Result;

/**
 *
 * @author Usuario
 */
public class CategoriaBean {

    //atributos
    private Connection connection;
    private PreparedStatement insertCategoria;
    private VariablesConexion variable;
    //constructores

    public CategoriaBean() throws SQLException {
        //instanciando
        variable = new VariablesConexion();
        variable.inicioConexion();
        //obteniendo la conexion
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");

    }

    //metodos
    @PreDestroy//cuando ya no la estemos utilizando automaticamente se ejecutara y se serrara la conexion
    public void cerrarConexion() {
        variable.cerrarConexion();
    }

    public String registrarCategoria(HttpServletRequest request) {
        String mensaje = "";
        if (request == null) {
            return "--";
        }
        if (connection != null) {
            try {
                //Definiendo la consulta
                StringBuilder query = new StringBuilder();
                query.append(" insert into categoria ");//append concatena los string
                query.append(" values (nextval('sec_cat'),?,?)");
                //los para metros que son enviados desde el formulario se ponen con '?'
                //nextval('sec_cat') son los valores automaticos puestos(indice automatico  )
                //enviando la consulta
                if (insertCategoria == null) {
                    insertCategoria = connection.prepareStatement(query.toString());
                }
                //rescatando los parametros del formulario jsp registrarCategoria
                /*Deben ir en el orden delas tablas para que los valores no salgan al reves*/
                String nombre = request.getParameter("nomCat");
                String descripcion = request.getParameter("desCat");
                //pasando los datos a los parametros de a consulta 
                insertCategoria.setString(1, nombre);
                insertCategoria.setString(2, descripcion);
                //ejecutando la consulta
                int registro = insertCategoria.executeUpdate();//Se realiza una modificacion en
                // la base de datos usamos >executeUpdate()
                if (registro == 1) {
                    mensaje = "Registro realizado con exito";
                } else {
                    mensaje = "Error al insertar el registro ";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }

    //Realizando listado de todas las categorias que se tienen que registrados
    public String listarCategoria() {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" select c.cod_cat,c.nom_cat,c.des_cat ");
        query.append(" from categoria c ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            while (resultado.next()) {
                salidaTabla.append("<tr>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getInt(1));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(3));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de Conexion");
        }

        return salidaTabla.toString();
    }

    //metodo que lista las categorias en un SELECT 
    public String listarCategoriaSelect() {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        
        query.append(" select c.cod_cat,c.nom_cat,c.des_cat ");
        query.append(" from categoria c ");
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

    //get and set 
}
